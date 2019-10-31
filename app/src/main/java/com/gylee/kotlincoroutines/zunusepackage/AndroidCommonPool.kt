package com.gylee.kotlincoroutines.zunusepackage

import android.os.AsyncTask
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

object AndroidCommonPool : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(block)
    }
}


fun main() = runBlocking {
    val pool = AndroidCommonPool
    println("${pool.toString()}")
    launch(AndroidCommonPool) {
        println("打印前的线程：${Thread.currentThread().name}")
        delay(1000L)
        println("打印前的线程：${Thread.currentThread().name}")
    }
    delay(2000L)

    println("main：即将完成退出")
}

