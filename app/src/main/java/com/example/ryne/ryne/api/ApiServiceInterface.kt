package com.example.ryne.ryne.api

import com.example.ryne.ryne.models.Album
import com.example.ryne.ryne.models.Post
import com.example.ryne.ryne.util.Constants
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServiceInterface {
    @GET("albums")
    fun getAlbumList(): Observable<List<Album>>

    @GET("posts")
    fun getPostList(): Observable<List<Post>>


    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}