package com.example.project2

import com.here.oksse.ServerSentEvent
import okhttp3.Request
import okhttp3.Response
import org.slf4j.LoggerFactory

class SSEListener : ServerSentEvent.Listener {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun onOpen(sse: ServerSentEvent?, response: Response?) {
        log.debug("onOpen")
    }

    override fun onMessage(sse: ServerSentEvent?, id: String?, event: String?, message: String?) {
        log.debug("---------> onMessage = $message")
    }

    override fun onComment(sse: ServerSentEvent?, comment: String?) {
        log.debug("onComment = $String")
    }

    override fun onRetryTime(sse: ServerSentEvent?, milliseconds: Long): Boolean {
        log.debug("onRetryTime")
        return false
    }

    override fun onRetryError(sse: ServerSentEvent?, throwable: Throwable?, response: Response?): Boolean {
        log.error("onRetryError", throwable)
        return false

    }

    override fun onClosed(sse: ServerSentEvent?) {
        log.debug("onClosed")
    }

    override fun onPreRetry(sse: ServerSentEvent?, originalRequest: Request?): Request {
        log.debug("onPreRetry")
        return originalRequest!!
    }
}