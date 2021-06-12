package com.example.common.domain

import javax.persistence.*

@Entity
@Table(name = "category")
class CategoryEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "order_by", nullable = true)
    var orderBy: Int? = null

) : AbstractEntity() {
    override fun toString(): String {
        return "CategoryEntity" +
                "(" +
                "id=$id, " +
                "name=$name, " +
                "orderBy=$orderBy" +
                "createdAt=$createdAt " +
                "updatedAt=$updatedAt " +
                ")"
    }
}
