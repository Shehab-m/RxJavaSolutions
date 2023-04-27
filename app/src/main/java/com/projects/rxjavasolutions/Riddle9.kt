package com.projects.rxjavasolutions

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {
    val main = Observable.interval(0, 1, TimeUnit.SECONDS).map { Unit }
    val trigger = Observable.just(Unit).delay(3, TimeUnit.SECONDS)
    Riddle9.solve(main, trigger)

    Riddle9.solveProof(main, trigger)
}

object Riddle9 {
    /**
     * As long as the [trigger] Observable does not emit an item, keep the [main] Observable alive.
     *
     * Use case: Cancel an Observable when something has happened. For instance, stop polling when the user has been logged out.
     */
    fun solve(main: Observable<Unit>, trigger: Observable<Unit>): Observable<Unit> =
        main.takeUntil(trigger)


    fun solveProof(main: Observable<Unit>, trigger: Observable<Unit>) {
        main.takeUntil(trigger).subscribe { println("from main") }
        trigger.subscribe { println("from trigger") }
        Thread.sleep(5000)
    }

}
