/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.project1.repository.mapper

import com.example.project1.domain.SubCategoryRecord
import org.apache.ibatis.annotations.DeleteProvider
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectKey
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.annotations.UpdateProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

@Mapper
interface SubCategoryMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    fun count(selectStatement: SelectStatementProvider): Long

    @DeleteProvider(type=SqlProviderAdapter::class, method="delete")
    fun delete(deleteStatement: DeleteStatementProvider): Int

    @InsertProvider(type=SqlProviderAdapter::class, method="insert")
    @SelectKey(statement=["SELECT LAST_INSERT_ID()"], keyProperty="record.id", before=false, resultType=Long::class)
    fun insert(insertStatement: InsertStatementProvider<SubCategoryRecord>): Int

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("SubCategoryRecordResult")
    fun selectOne(selectStatement: SelectStatementProvider): SubCategoryRecord?

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="SubCategoryRecordResult", value = [
        Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT),
        Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        Result(column="order_by", property="orderBy", jdbcType=JdbcType.INTEGER),
        Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<SubCategoryRecord>

    @UpdateProvider(type=SqlProviderAdapter::class, method="update")
    fun update(updateStatement: UpdateStatementProvider): Int
}