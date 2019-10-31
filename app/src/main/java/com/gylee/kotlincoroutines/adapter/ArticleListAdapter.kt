package com.gylee.kotlincoroutines.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.gylee.kotlincoroutines.R
import com.gylee.kotlincoroutines.entities.ArticleDetail
import kotlinx.android.synthetic.main.item_article_layout.view.*


class ArticleListAdapter(layoutRes: Int) :
    BaseQuickAdapter<ArticleDetail, BaseViewHolder>(layoutRes) {
    override fun convert(helper: BaseViewHolder, item: ArticleDetail?) {

        item?.let {
            helper.setText(R.id.tvArticleCategory, it.desc)
                .setText(R.id.tvArticleTitle, it.title)
                .setText(R.id.tvAuthorTime, "${it.superChapterName}/${it.chapterName} ")
        }


    }
}