package com.projects.rxjavasolutions

import io.reactivex.rxjava3.core.Observable

fun main() {
    val source = Observable.just(1, 2, 3, 4, 5, 6)
    Riddle3.solve(source)

    Riddle3.solveProof(source)
}

object Riddle3 {
    /**
     * Don't emit odd numbers from the [source] Observable.
     *
     * Use case: You want to filter certain items out.
     */
    fun solve(source: Observable<Int>): Observable<Int> = source.filter { it % 2 != 0 }

    fun solveProof(source: Observable<Int>) {
        source.filter { it % 2 == 0 }.subscribe { println(it) }
    }


}
