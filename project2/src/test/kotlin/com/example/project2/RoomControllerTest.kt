package com.example.project2

import com.example.project2.controller.PathTemplate
import com.example.project2.vm.Message
import com.here.oksse.OkSse
import okhttp3.Request
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono
import kotlin.random.Random


class RoomControllerTest(
    @Autowired val webTestClient: WebTestClient,
) : BaseTest() {

    // 登録
    val putUrl = "/${PathTemplate.MESSAGE.path}/put"
    val getUrl = "/${PathTemplate.MESSAGE.path}/get"

    @LocalServerPort
    var randomServerPort = 0

    @Test
    fun `Put message and Get message`() {

        val randomInt = Random.nextInt(5)

        val requestMessage = Message(
            message = "TEST123"
        )

        webTestClient.put().uri("$putUrl/$randomInt")
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(requestMessage), Message::class.java)
            .exchange()
            .expectStatus().isOk
        //.expectBody(Message::class.java).returnResult().responseBody!!

        val url: String = "http://127.0.0.1:$randomServerPort/message/get/$randomInt"
        val request: Request = Request.Builder().url(url).build()
        val okSse = OkSse()
        val sse: com.here.oksse.ServerSentEvent = okSse.newServerSentEvent(request, SSEListener())
        sse.request()

        webTestClient.put().uri("$putUrl/$randomInt")
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(requestMessage), Message::class.java)
            .exchange()
            .expectStatus().isOk
        //.expectBody(Message::class.java).returnResult().responseBody!!

        Thread.sleep(1_000)
        sse.close()
//
//        val listRoom: MutableList<Room> = webTestClient.get().uri("$getUrl/${room.roomId}")
//            .exchange()
//            .expectStatus().isOk
//            .expectBodyList(Room::class.java).returnResult()
//            .responseBody!!
//
//        assertEquals(room.roomId, roomIdGenerator.generateId(listRoom[0].userId!!, listRoom[1].userId!!))
    }

}
