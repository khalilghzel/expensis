package com.ghzel.expensis.ui.Composables.params.categories

import com.ghzel.domain.categories.dto.Category


data class CategoriesDataState(
    val isLoading: Boolean = false,
    val data: List<Category>  = listOf(),
    val error: Int? =null
)
