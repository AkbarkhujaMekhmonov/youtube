package com.example.youtubeapi.repository

import com.example.youtubeapi.retrofit.ApiService

class YouTubeRepository(val apiService : ApiService) {
     suspend fun getData()=apiService.getData()

}