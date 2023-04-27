package com.projects.rxjavasolutions

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {
    val source = Observable.just(1, 2, 3, 4)
    val function = { inputNum: Int -> Observable.just("number: $inputNum") }
    Riddle10.solve(source, function)

    Riddle10.solveProof(source,function)


}

object Riddle10 {
    /**
     * Use the [first] Observable and flatten it with the results of the [function] that returns an Observable.
     *
     * Use case: Get some user data and perform a network request with the user data and have both data accessible afterwards.
     */
    fun solve(
        first: Observable<Int>,
        function: (Int) -> Observable<String>
    ): Observable<Pair<Int, String>> {
        return first.flatMap { firstValue ->
            function(firstValue).map { functionResult -> Pair(firstValue, functionResult) }
        }
    }

    fun solveProof(
        first: Observable<Int>, function: (Int) -> Observable<String>
    ) {
        first.flatMap { firstValue ->
            function(firstValue).map { functionResult ->
                Pair(firstValue, functionResult)
            }
        }.subscribe{ println(it) }
    }


}
