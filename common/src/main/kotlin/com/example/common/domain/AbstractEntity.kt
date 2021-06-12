package com.example.common.domain

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

@MappedSuperclass
abstract class AbstractEntity {
    @Column(name = "created_at", nullable = false, updatable = false)
    var createdAt: LocalDateTime? = null

    @Column(name = "updated_at", nullable = false, updatable = false)
    var updatedAt: LocalDateTime? = null

    @PrePersist
    open fun onPrePersist() {
        createdAt = LocalDateTime.now()
        updatedAt = LocalDateTime.now()
    }

    @PreUpdate
    open fun onPreUpdate() {
        updatedAt = LocalDateTime.now()
    }
}