package com.dt5gen.landmarkhelper.model

import java.util.Date


data class Landmark(
    val id: Int,
    val name: String,
    val rating: Int,
    val creationDate: Date,
    val description: String,
    val type: LandmarkType,  // Новое поле для типа достопримечательности
)

data class Locality(
    val id: Int,
    val name: String,
    val region: String
)

data class Services(
    val id: Int,
    val name: String,
    val category: String
)