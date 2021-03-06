/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.project1.repository.mapper.base

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object CategoryDynamicSqlSupport {
    object Category : SqlTable("category") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val name = column<String>("name", JDBCType.VARCHAR)

        val orderBy = column<Int>("order_by", JDBCType.INTEGER)

        val createdAt = column<Date>("created_at", JDBCType.TIMESTAMP)

        val updatedAt = column<Date>("updated_at", JDBCType.TIMESTAMP)
    }
}