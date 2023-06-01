package com.example.imageloader.repo


import com.example.imageloader.models.ImagesData
import com.example.imageloader.network.Resource
import com.example.imageloader.network.RetrofitClient

class Repository:BaseRepo() {

    private val apiService=RetrofitClient.api
    suspend fun getImagesData(): Resource<ArrayList<ImagesData>> {
        return safeApiCall { apiService.getPhotos() }
    }
}