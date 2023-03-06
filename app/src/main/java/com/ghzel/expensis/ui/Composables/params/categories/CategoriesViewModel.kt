package com.ghzel.expensis.ui.Composables.params.categories

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghzel.domain.categories.dto.Category
import com.ghzel.domain.categories.usecases.DeleteCategoryUseCase
import com.ghzel.domain.categories.usecases.GetAllCategoriesCategoryUseCase
import com.ghzel.domain.categories.usecases.UpsertCategoryUseCase
import com.ghzel.expensis.R
import com.ghzel.expensis.ui.theme.main_color
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getAllCategoriesCategoryUseCase: GetAllCategoriesCategoryUseCase,
    private val upsertCategoryUseCase: UpsertCategoryUseCase,
    private val deleteCategoryUseCase: DeleteCategoryUseCase,


    ) :
    ViewModel(),
    LifecycleObserver {

    private val _stateData = mutableStateOf(CategoriesDataState())
    val state: State<CategoriesDataState> = _stateData

    val _stateList: MutableState<List<Category>> = mutableStateOf(listOf())

    fun getAllCategories() {
        viewModelScope.launch(Dispatchers.Main) {
            getAllCategoriesCategoryUseCase.invoke()
                .collect {
                    //   _stateList.value = it
                    _stateData.value = CategoriesDataState(isLoading = false, data = it)
                }

        }
    }

    fun deleteCategory(category: Category) {
        viewModelScope.launch(Dispatchers.Main) {
            deleteCategoryUseCase.invoke(category)

        }
    }


    init {
        getAllCategories()
        viewModelScope.launch(Dispatchers.IO) {
            delay(5000)
            upsertCategoryUseCase.invoke(
                Category(
                    null,
                    "new icons Test",
                    R.drawable.category_pleasure,
                    main_color.value.toLong(),
                    "hello i'm just a test for the new descriptions"
                )
            )
        }
    }
}
