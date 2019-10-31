package com.gylee.kotlincoroutines.zunusepackage

import android.os.Bundle
import android.view.View
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewLifecycleOwner.lifecycleScope.launch {
//            val params = TextViewCompat.getTextMetricsParams(tvContent)
//            val precomputedText = withContext(Dispatchers.Default) {
//                PrecomputedTextCompat.create("", params)
//            }
//            TextViewCompat.setPrecomputedText(tvContent, precomputedText)
//        }
    }
}