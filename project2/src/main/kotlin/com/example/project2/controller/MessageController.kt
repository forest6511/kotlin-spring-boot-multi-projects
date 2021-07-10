package com.example.project2.controller

import com.example.project2.vm.Message
import org.slf4j.LoggerFactory
import org.springframework.data.redis.connection.stream.*
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.data.redis.stream.StreamReceiver
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/message")
class MessageController(
    private val redisOperations: ReactiveRedisOperations<String, Message>,
    private val receiver: StreamReceiver<String, MapRecord<String, String, String>>
) {

    private val log = LoggerFactory.getLogger(javaClass)


    @CrossOrigin
    @GetMapping(path = ["/get/{roomId}"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun streamEvents(@PathVariable roomId: String): Flux<Message> {
        return receiver.receive(StreamOffset.fromStart(roomId)).map { msg ->
            log.info("get messages:$msg")
            Message(
                recordId = msg.id.value,
                message = msg.value["message"]!!
            )
        }
    }

    @CrossOrigin
    @GetMapping(path = ["/get/{roomId}/offset"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun streamEventsFrom(@PathVariable roomId: String, @PathVariable offset: String): Flux<Message> {
        return receiver.receive(StreamOffset.create(roomId, ReadOffset.from("offset"))).map { msg ->
            log.info("get offset:$offset messages:$msg")
            Message(
                recordId = msg.id.value,
                message = msg.value["message"]!!
            )
        }
    }

    @PutMapping("/put/{roomId}")
    fun put(@RequestBody message: Mono<Message>, @PathVariable roomId: String): Mono<RecordId> {
        return message.flatMap { msg ->
            val record: ObjectRecord<String, Message> = StreamRecords.newRecord()
                .ofObject(msg).withStreamKey(roomId)
            log.info("put message=$record")
            redisOperations.opsForStream<Any, Message>().add(record)
        }
    }
}