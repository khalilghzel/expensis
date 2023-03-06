package com.ghzel.domain.categories.repository

import com.ghzel.domain.categories.dto.Category
 import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {
    suspend fun upsert(category: Category)
    suspend fun delete(category: Category)
    suspend fun upsertList(categories: List<Category>)
    suspend fun getAllCategories(): Flow<List<Category>>
}