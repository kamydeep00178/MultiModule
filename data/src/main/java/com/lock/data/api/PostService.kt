package com.lock.data.api

import com.lock.data.models.PostResponse
import retrofit2.http.GET

interface PostService {
    @GET("/posts")
    suspend fun getPosts(): List<PostResponse>
}