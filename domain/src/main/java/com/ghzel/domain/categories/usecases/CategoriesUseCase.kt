package com.ghzel.domain.categories.usecases

data class CategoriesUseCase(
    val getAllCategoriesCategoryUseCase: GetAllCategoriesCategoryUseCase,
    val upsertCategoryUseCase: UpsertCategoryUseCase,
    val deleteCategoryUseCase: DeleteCategoryUseCase,
    val upsertListCategoryUseCase: UpsertListCategoryUseCase
)