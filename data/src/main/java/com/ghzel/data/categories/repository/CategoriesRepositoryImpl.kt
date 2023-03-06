package com.ghzel.data.categories.repository


import com.ghzel.data.categories.database.CategoriesDao
import com.ghzel.domain.categories.dto.Category
import com.ghzel.domain.categories.repository.CategoriesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ExperimentalCoroutinesApi
class CategoriesRepositoryImpl @Inject constructor(
    private val dao: CategoriesDao,
) : CategoriesRepository {

    override suspend fun upsert(category: Category) {
        dao.upsert(category)
    }

    override suspend fun delete(category: Category) {
        dao.delete(category)
    }

    override suspend fun upsertList(categories: List<Category>) {
        dao.upsertlist(categories)
    }

    override suspend fun getAllCategories(): Flow<List<Category>> {
        return dao.get_all_productstest()
    }

}