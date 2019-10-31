package com.gylee.kotlincoroutines.model

import androidx.lifecycle.MutableLiveData
import com.gylee.kotlincoroutines.entities.ArticleDetail
import com.gylee.kotlincoroutines.network.RetrofitManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * 数据资源获取处
 */
class ArticleRepository() {

    suspend fun loadPageData(page: Int): MutableList<ArticleDetail>? =
        withContext(Dispatchers.IO) {
            val newData = MutableLiveData<MutableList<ArticleDetail>>()
            val result = RetrofitManager.apiService.homeArticles(page).data.datas
            result
        }


    companion object {
        @Volatile
        private var instance: ArticleRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance
                    ?: ArticleRepository().also { instance = it }
            }
    }
}