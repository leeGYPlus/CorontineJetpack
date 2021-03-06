package com.gylee.kotlincoroutines.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gylee.kotlincoroutines.viewmodel.articlelist.ArticleListViewModel

class ArticleListFactory(private val repository: ArticleRepository) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArticleListViewModel(repository) as T
    }
}