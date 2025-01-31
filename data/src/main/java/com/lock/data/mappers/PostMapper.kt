package com.lock.data.mappers

import com.lock.data.models.PostResponse
import com.lock.domain.models.Post
import javax.inject.Inject

class PostMapper @Inject constructor() {

    fun postItemsToPostResponse(postItems: List<PostResponse>): List<Post> {
        return postItems.map { postItem ->
            Post(
                userId = postItem.userId,
                id = postItem.id,
                title = postItem.title,
                body = postItem.body
            )
        }
    }

}