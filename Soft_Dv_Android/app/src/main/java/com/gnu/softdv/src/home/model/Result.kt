package com.gnu.softdv.src.home.model

data class Result(
    val insectInfoIndex : Int,
    val scientificName : String,
    val kind : String,
    val sizeMax : Float,
    val lifeCycle : String,
    val image : String,
    val location : String,
    val breedTip : String,
)
