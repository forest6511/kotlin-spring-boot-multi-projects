package com.example.project2.config

import com.example.project2.vm.Message
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.connection.stream.ObjectRecord
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer
import org.springframework.data.redis.stream.StreamReceiver
import org.springframework.data.redis.stream.StreamReceiver.StreamReceiverOptions


@Configuration
class RedisConfiguration {

    @Bean
    fun redisOperations(factory: ReactiveRedisConnectionFactory?): ReactiveRedisOperations<String, Message>? {
        val serializer = Jackson2JsonRedisSerializer(Message::class.java).apply {
            setObjectMapper(jacksonObjectMapper())
        }
        val builder = RedisSerializationContext.newSerializationContext<String, Message>(StringRedisSerializer())
        val context = builder.value(serializer).build()
        return ReactiveRedisTemplate(factory!!, context)
    }

    @Bean
    fun streamReceiver(factory: ReactiveRedisConnectionFactory?): StreamReceiver<String, ObjectRecord<String, Message>>? {

        val receiverOptions = StreamReceiverOptions.builder()
            .targetType(Message::class.java).build()

        return StreamReceiver.create(factory, receiverOptions)
    }
}
