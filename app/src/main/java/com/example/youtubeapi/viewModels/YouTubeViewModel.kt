package com.example.youtubeapi.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youtubeapi.models.YouTubeApiData
import com.example.youtubeapi.repository.YouTubeRepository
import com.example.youtubeapi.retrofit.ApiClient
import com.example.youtubeapi.utils.NetworkHelper
import com.example.youtubeapi.utils.Resource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class YouTubeViewModel() : ViewModel() {
    private val youTubeRepository = YouTubeRepository(ApiClient.apiService)
    private val liveData = MutableLiveData<Resource<YouTubeApiData>>()
    fun getYouTubeData(context : Context) : LiveData<Resource<YouTubeApiData>> {
        val networkHelper = NetworkHelper(context)
        if (networkHelper.isNetworkConnected()) {
            try {
                viewModelScope.launch {
                    liveData.postValue(Resource.loading(null))
                    val response = youTubeRepository.getData()
                    if (response.isSuccessful) {
                        liveData.postValue(Resource.success(response.body()))
                    } else {
                        liveData.postValue(
                            Resource.error(
                                "response.errorBody()?.string().toString()",
                                null
                            )
                        )
                    }
                }
            } catch (e : Exception) {
            }
        } else {
            liveData.postValue(Resource.error("Internet not connection", null))
        }
        return liveData
    }


}