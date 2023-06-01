package com.example.imageloader.network

import com.example.imageloader.models.ImagesData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("photos")
    suspend fun getPhotos(): Response<ArrayList<ImagesData>>
}