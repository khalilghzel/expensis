package com.ghzel.domain.settings.usecase

import com.ghzel.domain.settings.repository.UpdateNightModeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpdateNightModeUseCase @Inject constructor(private val updateNightModeRepository: UpdateNightModeRepository) {
    suspend fun invoke(nightMode : Boolean) {
        return updateNightModeRepository.updateNightMode(nightMode)
    }
}