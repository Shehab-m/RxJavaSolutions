package com.projects.rxjavasolutions

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {
    val source = Observable.just(1,1,4,4,5,4,5)
    Riddle13.solve(source)

    Riddle13.solveProof(source)


}

object Riddle13 {
    /**
     * When the [source] emits the same value as it did last time, don't allow it to travel downstream.
     *
     * Use case: You only want to observe changes of a value but don't care if the same value has been emitted consecutively.
     */
    fun solve(source: Observable<Int>): Observable<Int> = source.distinctUntilChanged()


    fun solveProof(source: Observable<Int>) {
        source.distinctUntilChanged().subscribe{ println(it) }
    }

}
