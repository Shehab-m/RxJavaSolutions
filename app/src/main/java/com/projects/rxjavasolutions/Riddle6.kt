package com.projects.rxjavasolutions

import io.reactivex.rxjava3.core.Single

fun main() {
    val first = Single.just(1)
    val second = Single.just(2)
    Riddle6.solve(first, second)

    Riddle6.solveProof(first, second)

}

object Riddle6 {
    /**
     * Execute both [first] and [second] Single's in parallel and provide both results as a pair.
     * Assume both [first] and [second] will execute on a different thread already.
     * This is a slightly simpler version of [Riddle102], where no schedulers are applied by default.
     *
     * Use case: Execute two network requests in parallel and wait for each other and process the combined data.
     */
    fun solve(first: Single<Int>, second: Single<Int>): Single<Pair<Int, Int>> {
        return first.zipWith(second) { firstSingle, secondSingle ->
            Pair(
                firstSingle,
                secondSingle
            )
        }
    }

    fun solveProof(first: Single<Int>, second: Single<Int>) {
        first.zipWith(second) { firstSingle, secondSingle ->
            Pair(
                firstSingle,
                secondSingle
            )
        }.subscribe { pair ->
            println(pair)
        }
    }

}
