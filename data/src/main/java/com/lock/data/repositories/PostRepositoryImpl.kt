package com.lock.data.repositories

import com.lock.data.api.PostService
import com.lock.data.mappers.PostMapper
import com.lock.domain.models.Post
import com.lock.domain.repositories.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postService: PostService,
    private val postMapper: PostMapper
) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        return postMapper.postItemsToPostResponse(postService.getPosts())
    }
}
