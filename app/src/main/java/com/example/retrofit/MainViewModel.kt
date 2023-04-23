package com.example.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.model.Post
import com.example.retrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {


    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData();
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData();
    val customPost: MutableLiveData<Response<List<Post>>> = MutableLiveData();


    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost();
            myResponse.value = response
        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response = repository.getPost2(number);
            myResponse2.value = response
        }
    }

    fun getCustomPost(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId, sort, order);
            customPost.value = response;

        }
    }

}