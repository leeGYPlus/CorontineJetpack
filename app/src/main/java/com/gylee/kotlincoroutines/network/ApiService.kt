package com.gylee.kotlincoroutines.network

import com.gylee.kotlincoroutines.entities.HomeArticleEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    // 首页文章列表
    @GET("/article/list/{page}/json")
    suspend fun homeArticles(@Path("page") page: Int): HomeArticleEntity

}