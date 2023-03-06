package com.ghzel.data.categories.module


import android.content.Context
import com.ghzel.data.categories.database.CategoriesDao
import com.ghzel.data.categories.repository.CategoriesRepositoryImpl
import com.ghzel.data.common.local.DBModule
import com.ghzel.data.common.local.ExpensisDataBase
import com.ghzel.domain.categories.repository.CategoriesRepository
import com.ghzel.domain.categories.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Module(includes = [DBModule::class])
@InstallIn(SingletonComponent::class)
class CategoriesModule {

    @Singleton
    @Provides
    fun providecategoriesDao(@ApplicationContext appContext: Context): CategoriesDao {
        return ExpensisDataBase(appContext) .getCategoriesDao()
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Singleton
    @Provides
    fun provideCategoriesRepository(
        categoriesDao: CategoriesDao
    ): CategoriesRepository {
        return CategoriesRepositoryImpl(categoriesDao)
    }



    @Singleton
    @Provides
    fun provideUseCases(repository: CategoriesRepository) = CategoriesUseCase(
        getAllCategoriesCategoryUseCase = GetAllCategoriesCategoryUseCase(repository),
        upsertCategoryUseCase = UpsertCategoryUseCase(repository),
        upsertListCategoryUseCase = UpsertListCategoryUseCase(repository),
        deleteCategoryUseCase = DeleteCategoryUseCase(repository),
        )
}