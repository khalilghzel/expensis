package com.ghzel.data.categories.database

import androidx.room.*
import com.ghzel.domain.categories.dto.Category
import kotlinx.coroutines.flow.Flow



@Dao
interface CategoriesDao {
    @Query("select *  from categories")
    fun get_all_productstest(): Flow<List<Category>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(category : Category)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertlist(article : List<Category> )

    @Delete
    suspend fun delete(category : Category)

}