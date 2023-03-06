package com.ghzel.data.common.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ghzel.data.categories.database.CategoriesDao
import com.ghzel.domain.categories.dto.Category

@Database(
    entities = [Category::class],
    version = 1

)
abstract class ExpensisDataBase : RoomDatabase() {
    abstract fun getCategoriesDao(): CategoriesDao

    companion object {
        @Volatile
        private var instance: ExpensisDataBase? = null
        private val lock = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: createDataBase(context).also { instance = it }
        }
        private fun createDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ExpensisDataBase::class.java,
                "expenses_db.db"
            ).fallbackToDestructiveMigration().build()
    }

 }




