package com.example.gallerify.data

data class FlckrPhoto (
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: Int,
    val photo: List<images>
)