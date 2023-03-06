package com.ghzel.domain.settings.repository


interface UpdateNightModeRepository {
    suspend fun updateNightMode(nightMode: Boolean)

}