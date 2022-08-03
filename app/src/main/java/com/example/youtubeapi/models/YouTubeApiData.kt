package com.example.youtubeapi.models

data class YouTubeApiData(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val pageInfo: PageInfo,
    val regionCode: String
)