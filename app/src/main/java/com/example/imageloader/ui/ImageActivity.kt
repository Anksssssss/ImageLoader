package com.example.imageloader.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imageloader.ui.adapter.ImagesAdapter
import com.example.imageloader.databinding.ActivityImageBinding
import com.example.imageloader.network.Resource
import com.example.imageloader.ui.viewmodel.ImageViewModel

class ImageActivity : AppCompatActivity() {

    private lateinit var binding : ActivityImageBinding
    private lateinit var viewModel : ImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[ImageViewModel::class.java]
        viewModel.getPhotoList()
        initObserver()
    }

    fun initObserver(){
        viewModel.photoList.observe(this) {
            when (it) {
                is Resource.Error -> {
                    it.message?.let { message ->
                        binding.loadingPb.visibility = View.GONE
                        binding.errorTv.visibility = View.VISIBLE
                        binding.errorTv.text = message
                    }
                }
                is Resource.Loading -> {
                    binding.loadingPb.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    val imageAdapter = it.data?.let { photoList -> ImagesAdapter(photoList) }
                    binding.imageActivityRv.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = imageAdapter
                    }
                    binding.loadingPb.visibility = View.GONE
                }
            }
        }
    }
}