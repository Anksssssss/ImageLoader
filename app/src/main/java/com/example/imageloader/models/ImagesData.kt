package com.example.imageloader.models

import com.google.gson.annotations.SerializedName

data class ImagesData(
        @SerializedName("albumId")
        val albumId: Int? = null,
        @SerializedName("id")
        val id: Int? = null,
        @SerializedName("thumbnailUrl")
        val thumbnailUrl: String? = null,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("url")
        val url: String? = null
    )
