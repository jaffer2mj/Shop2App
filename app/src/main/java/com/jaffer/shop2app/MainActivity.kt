package com.jaffer.shop2app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val page = 1;
    val access_token = "dbd13cc84892fa9cf869b16dd5789b7b"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)


        /////////////////////// API
        val interceptor = HttpLoggingInterceptor()
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://collectiveoutlet.myshopify.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ShopifyProductsAPI::class.java)

        api.fetchAllProducts(page, access_token).enqueue(object : Callback<ShopifyProducts> {
            override fun onResponse(
                call: Call<ShopifyProducts>,
                response: Response<ShopifyProducts>
            ) {
                val shopifyProducts = response.body();
                if (shopifyProducts != null) {
                    recycler_view.adapter =
                        ItemsAdapter(shopifyProducts.products, this@MainActivity);
                }

            }

            override fun onFailure(call: Call<ShopifyProducts>, t: Throwable) {
                println("Failed: " + t.message)
            }

        })
    }
}