package com.dt5gen.landmarkhelper.model


data class Landmark(
    val id: Int,
    val name: String,
    val description: String
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