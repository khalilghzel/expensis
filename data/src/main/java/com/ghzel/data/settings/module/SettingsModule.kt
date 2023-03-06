package com.ghzel.data.settings.module



import com.ghzel.data.common.local.UserData
import com.ghzel.data.settings.repository.UpdateNightModeImpl
import com.ghzel.domain.settings.repository.UpdateNightModeRepository
import com.ghzel.domain.settings.usecase.UpdateNightModeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SettingsModule {


    @Singleton
    @Provides
    fun provideProductRepository(userData: UserData): UpdateNightModeRepository {
        return UpdateNightModeImpl( userData)
    }


    @Singleton
    @Provides
    fun provideUseCases(repository: UpdateNightModeRepository) = UpdateNightModeUseCase(
        updateNightModeRepository = repository
    )
}