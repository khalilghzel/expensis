package com.ghzel.domain.categories.usecases


import com.ghzel.domain.categories.dto.Category
import com.ghzel.domain.categories.repository.CategoriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllCategoriesCategoryUseCase @Inject constructor(private val categoriesRepository: CategoriesRepository) {
    suspend fun invoke(): Flow<List<Category>> {
        return categoriesRepository.getAllCategories()
    }
}