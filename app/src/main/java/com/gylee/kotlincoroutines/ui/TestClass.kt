package com.gylee.kotlincoroutines.ui

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TestClass {
    fun test() {
        runBlocking {
            launch {
                println("")
            }
            show()
        }

    }

    suspend fun show() {
        println("show")
    }
}


// suspend, 被 suspend 修饰的函数只能被 suspend 函数或在协程中调用，
//因为 suspend 修饰的函数(或 Lambda )，被编译后会多一个参数，该参数类型为 Continuation
//协程的异步调用本质就是一次回调


//start(block, receiver, this)最终调用 CoroutineStart.invoke

//IntrinsicsKt.class  -》 IntrinsicsJvm.kt  -》 invokeSuspend 方法执行