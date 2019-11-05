package com.gylee.kotlincoroutines.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gylee.kotlincoroutines.R
import com.gylee.kotlincoroutines.adapter.ArticleListAdapter
import com.gylee.kotlincoroutines.entities.ArticleDetail
import com.gylee.kotlincoroutines.model.ArticleRepository
import com.gylee.kotlincoroutines.viewmodel.articlelist.ArticleListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class ArticleListActivity : AppCompatActivity() {
    var page = 1
    private val articleAdapter by lazy {
        ArticleListAdapter(R.layout.item_article_layout)
    }
    private val viewModel by lazy {
        ArticleListViewModel(ArticleRepository.getInstance())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvArticleList.adapter = articleAdapter
        viewModel.articles?.observe(this, Observer<List<ArticleDetail>> {
            articleAdapter.addData(it)
        })
    }

    fun fetchData(view: View) {
        when {
            page > 10 -> page = 1
        }
        viewModel.fetchArticleList2(page)
        page++
    }
}
