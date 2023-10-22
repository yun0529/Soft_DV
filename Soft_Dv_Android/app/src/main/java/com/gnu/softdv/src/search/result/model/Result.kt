package com.gnu.softdv.src.search.result.model

data class Result(
    val index : Int,
    val kind : String,
    val image :String?,
    val scientificName : String
)