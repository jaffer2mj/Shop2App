package com.jaffer.shop2app


data class Product(
    val id: Long,
    val title: String,
    val body_html: String,
    val vendor: String,
    val product_type: String,
    val tags: String,
    val image: Image
)

data class Image(
    val src: String
)