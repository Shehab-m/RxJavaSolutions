package com.projects.rxjavasolutions

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {
    val source = Observable.just(1).map { it / 0 }
    Riddle12.solve(source)

    Riddle12.solveProof(source)


}

object Riddle12 {
    /**
     * In case the [source] Observable emits an error, don't emit the error and instead complete the Observable with a value of 5.
     *
     * Use case: Getting a network error and you want to recover and show some default state.
     */
    fun solve(source: Observable<Int>): Observable<Int> = source.onErrorReturnItem(5)

    fun solveProof(source: Observable<Int>) {
        source.onErrorReturnItem(5).subscribeBy(
            onNext = {
                println("onNext: $it")
            }, onError = {
                println("onError: $it")
            }
        )
    }

}
