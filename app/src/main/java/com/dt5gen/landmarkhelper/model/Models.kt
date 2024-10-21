package com.dt5gen.landmarkhelper.model

import java.util.Date


data class LandmarkDTO(
    val id: Int,
    val name: String,
    val rating: Int,
    val creationDate: Date,
    val description: String,
    val type: LandmarkType,  // Новое поле для типа достопримечательности
)

data class LocalityDTO(
    val id: Long,
    val name: String,
    val description: String,
    val latitude: Double,
    val longitude: Double,
    val landmarkIds: List<Long> = emptyList()
)

data class ServicesDTO(
    val id: Long? = null,
    val name: String,
    val description: String? = null,
    val provider: String? = null,
    val type: ServiceType? = null,
    val landmarkId: Long? = null,
    val performer: String? = null
)