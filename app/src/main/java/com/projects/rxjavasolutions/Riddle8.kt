package com.projects.rxjavasolutions

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {
    val source = Observable.just(Unit)
    Riddle8.solve(source)

    Riddle8.solveProof(source)


}

object Riddle8 {
    /**
     * Delay the entire [source] by 200ms. This includes subscribing, emissions and terminal events.
     *
     * Use case: Make an Observable "lazy" for some time. For instance, when wanting to postpone some UI action.
     */
    fun solve(source: Observable<Unit>): Observable<Unit> = source.delay(200, TimeUnit.MILLISECONDS)


    fun solveProof(source: Observable<Unit>) {
        source.delay(200, TimeUnit.MILLISECONDS)
            .zipWith(Observable.just("response after 200ms")) { _, internal -> internal }
            .map { it.toString() }
            .subscribe {
                println(it)
            }
        Thread.sleep(200)
    }


}



