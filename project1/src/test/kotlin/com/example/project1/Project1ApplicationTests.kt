package com.example.project1

import com.example.project1.domain.CategoryRecord
import com.example.project1.repository.mapper.CategoryDynamicSqlSupport.Category
import com.example.project1.repository.mapper.CategoryMapper
import com.example.project1.repository.mapper.count
import com.example.project1.repository.mapper.insert
import com.example.project1.repository.mapper.select
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Transactional
@SpringBootTest
class Project1ApplicationTests(
    @Autowired val categoryMapper: CategoryMapper
) {

    // https://github.com/mybatis/mybatis-dynamic-sql/blob/master/src/test/kotlin/examples/kotlin/mybatis3/canonical/PersonMapperTest.kt
    @Test
    fun `select all category`() {
        val rows = categoryMapper.select { allRows() }
        rows.forEach { it ->
            println(it)
        }
    }

    @Test
    fun `select all category order by`() {
        val rows = categoryMapper.select {
            allRows()
            orderBy(Category.orderBy.descending())
        }
        rows.forEach { it ->
            println(it)
        }
    }

    @Test
    fun `count where category`() {
        val rows = categoryMapper.count {
            where(Category.id, isEqualTo(1))
        }
        assertEquals(1L, rows)
    }

    @Test
    fun `count all category`() {
        val rows = categoryMapper.count {
            allRows()
        }
        assertEquals(3L, rows)
    }

    @Test
    fun `insert one category`() {
        val record = CategoryRecord(
            name = "テストカテゴリ",
            orderBy = 5,
            updatedAt = Date(),
            createdAt = Date()
        )

        assertTrue((record.id == null))

        categoryMapper.insert(record)

        // Id is set after inserting.
        assertTrue((record.id != null))
    }


}
