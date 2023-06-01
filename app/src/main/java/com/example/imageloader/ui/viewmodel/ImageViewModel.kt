package com.example.imageloader.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imageloader.models.ImagesData
import com.example.imageloader.network.Resource
import com.example.imageloader.repo.Repository
import kotlinx.coroutines.launch

class ImageViewModel() : ViewModel() {
    private val repository = Repository()

    private val _photoList = MutableLiveData<Resource<ArrayList<ImagesData>>>()
    val photoList: LiveData<Resource<ArrayList<ImagesData>>> = _photoList

    fun getPhotoList() = viewModelScope.launch {
        _photoList.postValue(Resource.Loading())
        _photoList.postValue(repository.getImagesData())
    }
}