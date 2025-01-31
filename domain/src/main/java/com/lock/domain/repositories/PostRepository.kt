package com.lock.domain.repositories

import com.lock.domain.models.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}