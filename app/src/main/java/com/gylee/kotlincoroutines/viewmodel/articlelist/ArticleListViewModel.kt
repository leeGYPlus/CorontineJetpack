package com.gylee.kotlincoroutines.viewmodel.articlelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gylee.kotlincoroutines.entities.ArticleDetail
import com.gylee.kotlincoroutines.model.ArticleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ArticleListViewModel(private val repository: ArticleRepository) : ViewModel() {
    var articles: MutableLiveData<MutableList<ArticleDetail>>? = MutableLiveData()

    private val viewModelJob = Job()

    /**
     * This is the scope for all coroutines launched by [PlantDetailViewModel].
     *
     * Since we pass [viewModelJob], you can cancel all coroutines launched by [viewModelScope] by calling
     * viewModelJob.cancel().  This is called in [onCleared].
     */
    private val viewModelScope2 = CoroutineScope(Dispatchers.Main + viewModelJob)


    fun fetchArticleList(page: Int) = viewModelScope.launch {
        val list = repository.loadPageData(page)
        articles?.value = list
    }

    fun fetchArticleList2(page: Int) = viewModelScope2.launch {
        val list = repository.loadPageData(page)
        articles?.value = list
    }

}
