/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.project1.repository.mapper

import com.example.project1.domain.CategoryRecord
import com.example.project1.repository.mapper.CategoryDynamicSqlSupport.Category
import com.example.project1.repository.mapper.CategoryDynamicSqlSupport.Category.createdAt
import com.example.project1.repository.mapper.CategoryDynamicSqlSupport.Category.id
import com.example.project1.repository.mapper.CategoryDynamicSqlSupport.Category.name
import com.example.project1.repository.mapper.CategoryDynamicSqlSupport.Category.orderBy
import com.example.project1.repository.mapper.CategoryDynamicSqlSupport.Category.updatedAt
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun CategoryMapper.count(completer: CountCompleter) =
    countFrom(this::count, Category, completer)

fun CategoryMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Category, completer)

fun CategoryMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun CategoryMapper.insert(record: CategoryRecord) =
    insert(this::insert, record, Category) {
        map(name).toProperty("name")
        map(orderBy).toProperty("orderBy")
        map(createdAt).toProperty("createdAt")
        map(updatedAt).toProperty("updatedAt")
    }

fun CategoryMapper.insertSelective(record: CategoryRecord) =
    insert(this::insert, record, Category) {
        map(name).toPropertyWhenPresent("name", record::name)
        map(orderBy).toPropertyWhenPresent("orderBy", record::orderBy)
        map(createdAt).toPropertyWhenPresent("createdAt", record::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", record::updatedAt)
    }

private val columnList = listOf(id, name, orderBy, createdAt, updatedAt)

fun CategoryMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Category, completer)

fun CategoryMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Category, completer)

fun CategoryMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Category, completer)

fun CategoryMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun CategoryMapper.update(completer: UpdateCompleter) =
    update(this::update, Category, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: CategoryRecord) =
    apply {
        set(name).equalTo(record::name)
        set(orderBy).equalTo(record::orderBy)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: CategoryRecord) =
    apply {
        set(name).equalToWhenPresent(record::name)
        set(orderBy).equalToWhenPresent(record::orderBy)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
    }

fun CategoryMapper.updateByPrimaryKey(record: CategoryRecord) =
    update {
        set(name).equalTo(record::name)
        set(orderBy).equalTo(record::orderBy)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
        where(id, isEqualTo(record::id))
    }

fun CategoryMapper.updateByPrimaryKeySelective(record: CategoryRecord) =
    update {
        set(name).equalToWhenPresent(record::name)
        set(orderBy).equalToWhenPresent(record::orderBy)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
        where(id, isEqualTo(record::id))
    }