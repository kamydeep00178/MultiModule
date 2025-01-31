package com.lock.multimoduleproject.di

import com.lock.data.repositories.PostRepositoryImpl
import com.lock.domain.repositories.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(repository: PostRepositoryImpl): PostRepository
}