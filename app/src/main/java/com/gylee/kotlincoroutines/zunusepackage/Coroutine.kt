package com.gylee.kotlincoroutines.zunusepackage

import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Request


fun main(args: Array<String>) = runBlocking {

}


private val okHttpClient = OkHttpClient()
private val request = Request.Builder().url("").get().build()

fun displayText(textView: TextView) = runBlocking {
    launch(Dispatchers.Main) {
        textView.text = async(AndroidCommonPool) {
            okHttpClient.newCall(request).execute().body?.toString()
        }.await()
    }
}
fun displayText2() = runBlocking {
    launch(Dispatchers.Main) {
        val test = async(AndroidCommonPool) {
            okHttpClient.newCall(request).execute().body?.toString()
        }.await()
    }
}

suspend fun gdg()
{

}