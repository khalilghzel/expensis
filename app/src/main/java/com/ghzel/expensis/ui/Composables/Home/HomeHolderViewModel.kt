package com.ghzel.expensis.ui.Composables.Home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghzel.data.common.local.UserData
import com.ghzel.domain.settings.usecase.UpdateNightModeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeHolderViewModel @Inject constructor(
    private val updateNightModeUseCase: UpdateNightModeUseCase,
    private val data: UserData
) :
    ViewModel() {
    val isloading = mutableStateOf(false)
    val nightMode = data.nightMode

    fun updateNightMode(nightMode: Boolean) {
        viewModelScope.launch(IO) {
            updateNightModeUseCase.invoke(nightMode)
        }
    }
}