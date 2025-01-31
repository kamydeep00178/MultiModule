package com.lock.domain.usecase

import com.lock.domain.repositories.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repository: PostRepository) {
    operator fun invoke() = flow {
        emit(repository.getPosts())
    }.flowOn(Dispatchers.IO)
}