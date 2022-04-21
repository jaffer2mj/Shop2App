package com.jaffer.shop2app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ShopifyProductsAPI {
    //https://shopicruit.myshopify.com/admin/products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6
    @GET("/admin/products.json")
    fun fetchAllProducts(@Query("page") page: Int,
                         @Query ("access_token") access_token: String):
            Call<ShopifyProducts>
}
