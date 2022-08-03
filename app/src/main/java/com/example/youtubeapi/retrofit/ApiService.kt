package com.example.youtubeapi.retrofit

import com.example.youtubeapi.models.YouTubeApiData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    suspend fun getData(
        @Query("key") key : String = "AIzaSyD3H6FaQ0ftOYBXanpAuGdO89jN6Y1Mlg4",
        @Query("chanelId") chanelId : String = "UC9rhaVQGOQcylRVkSUM7OAQ",
        @Query("part") part : String = "snippet,id",
        @Query("order") oreder : String = "date",
        @Query("maxResults") maxResults : Int = 20
    ):Response<YouTubeApiData>
}