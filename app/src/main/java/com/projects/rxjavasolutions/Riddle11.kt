package com.projects.rxjavasolutions

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {
    val source = Observable.interval(0, 1, TimeUnit.SECONDS).map { Unit }
    Riddle11.solve(source)

    Riddle11.solveProof(source)


}

object Riddle11 {
    /**
     * Let the first emission of the [source] within a time window of 300ms travel downstream but don't emit any other events until the next time window.
     *
     * Use case: Handle the click of a button right away but prevent double clicking by not handling multiple click events within a given time window.
     */
    fun solve(source: Observable<Unit>): Observable<Unit> =
        source.throttleFirst(300, TimeUnit.MILLISECONDS)


    fun solveProof(source: Observable<Unit>) {
        source.throttleFirst(300, TimeUnit.MILLISECONDS).subscribe{ println("emitted") }
        Thread.sleep(6000)
    }
}
