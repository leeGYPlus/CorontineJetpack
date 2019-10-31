package com.gylee.kotlincoroutines.viewmodel.articlelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gylee.kotlincoroutines.entities.ArticleDetail
import com.gylee.kotlincoroutines.model.ArticleRepository
import com.gylee.kotlincoroutines.utils.LogUtil
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ArticleListViewModel(private val repository: ArticleRepository) : ViewModel() {
    var articles: MutableLiveData<MutableList<ArticleDetail>>? = MutableLiveData()

    fun fetchArticleList(page: Int) = viewModelScope.launch {
        val list = repository.loadPageData(page)
        articles?.value = list
    }

}
