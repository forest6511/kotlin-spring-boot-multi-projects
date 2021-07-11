package com.example.project2

import com.example.project2.controller.PathTemplate
import com.example.project2.vm.Message
import com.google.gson.Gson
import com.here.oksse.OkSse
import com.here.oksse.ServerSentEvent
import okhttp3.Request
import okhttp3.Response
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono
import java.util.concurrent.TimeUnit
import kotlin.random.Random


class MessageControllerTest(
    @Autowired val webTestClient: WebTestClient,
) : BaseTest() {

    val putUrl = "/${PathTemplate.MESSAGE.path}/put"
    val getUrl = "/${PathTemplate.MESSAGE.path}/get"

    val localhost = "http://127.0.0.1:"
    private val TEST_TIMEOUT = TimeUnit.SECONDS.toMillis(60)


    @LocalServerPort
    var randomServerPort = 0

    @Test
    fun `SSE Message #1`() {

        val randomInt = Random.nextInt(5)
        val message = "TEST123"
        putMessage(message, randomInt)

        val url = "$localhost$randomServerPort$getUrl/$randomInt"
        val request: Request = Request.Builder().url(url).build()
        val okSse = OkSse()
        val sse: ServerSentEvent = okSse.newServerSentEvent(
            request, object : ServerSentEvent.Listener {
                private val log = LoggerFactory.getLogger(javaClass)

                override fun onOpen(sse: ServerSentEvent?, response: Response?) {
                }

                override fun onMessage(sse: ServerSentEvent?, id: String?, event: String?, response: String?) {
                    log.debug("$response")
                    val msg: Message = Gson().fromJson(response, Message::class.java)
                    //assertEquals(message, msg.message)
                }

                override fun onComment(sse: ServerSentEvent?, comment: String?) {
                }

                override fun onRetryTime(sse: ServerSentEvent?, milliseconds: Long): Boolean {
                    return true
                }

                override fun onRetryError(
                    sse: ServerSentEvent?, throwable: Throwable?, response: Response?
                ): Boolean {
                    return true
                }

                override fun onClosed(sse: ServerSentEvent?) {
                }

                override fun onPreRetry(sse: ServerSentEvent?, originalRequest: Request?): Request {
                    return originalRequest!!
                }

            })
        sse.request()
        sse.close()
    }

    @Test
    fun `SSE Message #2`() {
        var isAlive: Boolean = true
        var hasReceivedMessage = false

        val message = "12345678"
        val url = "$localhost$randomServerPort$getUrl/${message.toInt()}"

        val okSse = OkSse()

        val request: Request = Request.Builder().url(url).build()
        val sse: ServerSentEvent = okSse.newServerSentEvent(request, object : ServerSentEvent.Listener {
            override fun onOpen(sse: ServerSentEvent?, response: Response) {
            }

            override fun onMessage(sse: ServerSentEvent, id: String?, event: String, message: String) {
                val msg: Message = Gson().fromJson(message, Message::class.java)
                if(!hasReceivedMessage){
                    assertEquals("12345678", msg.message)
                }
                hasReceivedMessage = true
            }

            override fun onComment(sse: ServerSentEvent, comment: String) {
                println("New OkSse comment $comment")
            }

            override fun onRetryTime(sse: ServerSentEvent, milliseconds: Long): Boolean {
                println("OkSse sends retry time $milliseconds milliseconds")
                return true
            }

            override fun onRetryError(sse: ServerSentEvent?, throwable: Throwable?, response: Response?): Boolean {
                throw RuntimeException(throwable)
            }

            override fun onClosed(sse: ServerSentEvent) {
                isAlive = false
                println("OkSse connection closed")
            }

            override fun onPreRetry(sse: ServerSentEvent?, originalRequest: Request?): Request? {
                throw RuntimeException("No retry was expected")
            }
        })

        putMessage(message, message.toInt())

        val startTime = System.currentTimeMillis()
        while (isAlive) {
            try {
                Thread.sleep(100)
                if (System.currentTimeMillis() - startTime > TEST_TIMEOUT || hasReceivedMessage) {
                    sse.close()
                }
            } catch (e: Exception) {
                isAlive = false
            }
        }

        sse.close()
    }

    fun putMessage(message: String, randomInt: Int) {
        val requestMessage = Message(
            recordId = "",
            message = message
        )

        webTestClient.put().uri("$putUrl/$randomInt")
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(requestMessage), Message::class.java)
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .consumeWith { response -> //println(response)
            }
    }


}
