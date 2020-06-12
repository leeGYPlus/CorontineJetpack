package com.gylee.kotlincoroutines.zunusepackage.forkjoinpool

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.RecursiveTask
import java.util.concurrent.TimeUnit

private class CountTask(val start: Int, val end: Int) : RecursiveTask<Int>() {
    override fun compute(): Int {
        var sum = 0
        if (end - start <= 5) {
            for (i in start..end) {
                Thread.sleep(500)
                sum += i
            }
            println("${Thread.currentThread().name}-sum from $start to $end with result $sum")
        } else {
            val mid = (start + end) / 2
            val leftTask = CountTask(start, mid - 1)
            val rightTask = CountTask(mid, end)
            //切分大任务
            leftTask.fork()
            rightTask.fork()
            //合并小任务结果
            sum += leftTask.join()
            sum += rightTask.join()
        }
        return sum
    }
}

@RequiresApi(Build.VERSION_CODES.N)
fun main(args: Array<String>) {
    val pool = ForkJoinPool.commonPool()
    println("Pool init:$pool")

    val task = pool.submit(CountTask(1, 100))
    println("total:${task.get()}")

    try {
        pool.awaitTermination(10, TimeUnit.SECONDS)
    } catch (e: InterruptedException) {
        println(e.message)
    }
    pool.shutdown()
}