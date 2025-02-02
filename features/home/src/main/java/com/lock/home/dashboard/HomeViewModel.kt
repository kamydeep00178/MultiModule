package com.lock.home.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lock.domain.common.Resource
import com.lock.domain.models.Post
import com.lock.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(
    private val postUseCase: GetPostsUseCase
) : ViewModel() {

    private val _postList = MutableStateFlow<Resource<List<Post>>>(Resource.Loading())
    val postList: StateFlow<Resource<List<Post>>> = _postList.asStateFlow()

    val _selectedCategory = MutableStateFlow<String>(getCategories().first())
    val selectedCategory : StateFlow<String> = _selectedCategory


    fun getPosts() {
        viewModelScope.launch {
            postUseCase.invoke().onStart {
                _postList.value = Resource.Loading()
            }.catch {
                _postList.value = Resource.Error(it.localizedMessage)
            }.collect {
                _postList.value = Resource.Success(it)
            }
        }
    }

    fun getCategories() = listOf("Barger","Pizza","Snacks","Desserts","Drinks")

    fun selectedCategory(item : String) {
        _selectedCategory.value = item
    }

}