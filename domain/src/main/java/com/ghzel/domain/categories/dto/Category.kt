package com.ghzel.domain.categories.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(
    tableName = "categories"
)
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val name: String,
    val icon: Int  ,
    val color: Long,
    val description: String,
) : Serializable