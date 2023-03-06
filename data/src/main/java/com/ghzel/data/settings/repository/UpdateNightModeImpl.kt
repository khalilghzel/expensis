package com.ghzel.data.settings.repository


import com.ghzel.data.common.local.UserData
import com.ghzel.domain.settings.repository.UpdateNightModeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ExperimentalCoroutinesApi
class UpdateNightModeImpl @Inject constructor(
    private val dataStore: UserData,
) : UpdateNightModeRepository {

    override suspend fun updateNightMode(nightMode: Boolean) {
        dataStore.updateNightMode(nightMode)
    }

}