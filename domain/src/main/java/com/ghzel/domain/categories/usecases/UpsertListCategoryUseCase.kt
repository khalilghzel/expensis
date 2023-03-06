package com.ghzel.domain.categories.usecases


import com.ghzel.domain.categories.dto.Category
import com.ghzel.domain.categories.repository.CategoriesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpsertListCategoryUseCase @Inject constructor(private val categoriesRepository: CategoriesRepository) {
    suspend fun invoke( categories : List<Category>){
        return categoriesRepository.upsertList(categories)
    }
}