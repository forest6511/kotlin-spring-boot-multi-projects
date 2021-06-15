/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.project1.repository.mapper

import com.example.project1.domain.SubCategoryRecord
import com.example.project1.repository.mapper.SubCategoryDynamicSqlSupport.SubCategory
import com.example.project1.repository.mapper.SubCategoryDynamicSqlSupport.SubCategory.categoryId
import com.example.project1.repository.mapper.SubCategoryDynamicSqlSupport.SubCategory.createdAt
import com.example.project1.repository.mapper.SubCategoryDynamicSqlSupport.SubCategory.id
import com.example.project1.repository.mapper.SubCategoryDynamicSqlSupport.SubCategory.name
import com.example.project1.repository.mapper.SubCategoryDynamicSqlSupport.SubCategory.orderBy
import com.example.project1.repository.mapper.SubCategoryDynamicSqlSupport.SubCategory.updatedAt
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun SubCategoryMapper.count(completer: CountCompleter) =
    countFrom(this::count, SubCategory, completer)

fun SubCategoryMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, SubCategory, completer)

fun SubCategoryMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun SubCategoryMapper.insert(record: SubCategoryRecord) =
    insert(this::insert, record, SubCategory) {
        map(categoryId).toProperty("categoryId")
        map(name).toProperty("name")
        map(orderBy).toProperty("orderBy")
        map(createdAt).toProperty("createdAt")
        map(updatedAt).toProperty("updatedAt")
    }

fun SubCategoryMapper.insertSelective(record: SubCategoryRecord) =
    insert(this::insert, record, SubCategory) {
        map(categoryId).toPropertyWhenPresent("categoryId", record::categoryId)
        map(name).toPropertyWhenPresent("name", record::name)
        map(orderBy).toPropertyWhenPresent("orderBy", record::orderBy)
        map(createdAt).toPropertyWhenPresent("createdAt", record::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", record::updatedAt)
    }

private val columnList = listOf(id, categoryId, name, orderBy, createdAt, updatedAt)

fun SubCategoryMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, SubCategory, completer)

fun SubCategoryMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, SubCategory, completer)

fun SubCategoryMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, SubCategory, completer)

fun SubCategoryMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun SubCategoryMapper.update(completer: UpdateCompleter) =
    update(this::update, SubCategory, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: SubCategoryRecord) =
    apply {
        set(categoryId).equalTo(record::categoryId)
        set(name).equalTo(record::name)
        set(orderBy).equalTo(record::orderBy)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: SubCategoryRecord) =
    apply {
        set(categoryId).equalToWhenPresent(record::categoryId)
        set(name).equalToWhenPresent(record::name)
        set(orderBy).equalToWhenPresent(record::orderBy)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
    }

fun SubCategoryMapper.updateByPrimaryKey(record: SubCategoryRecord) =
    update {
        set(categoryId).equalTo(record::categoryId)
        set(name).equalTo(record::name)
        set(orderBy).equalTo(record::orderBy)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
        where(id, isEqualTo(record::id))
    }

fun SubCategoryMapper.updateByPrimaryKeySelective(record: SubCategoryRecord) =
    update {
        set(categoryId).equalToWhenPresent(record::categoryId)
        set(name).equalToWhenPresent(record::name)
        set(orderBy).equalToWhenPresent(record::orderBy)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
        where(id, isEqualTo(record::id))
    }