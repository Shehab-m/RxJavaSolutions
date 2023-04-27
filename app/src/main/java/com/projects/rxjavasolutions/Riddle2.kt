package com.projects.rxjavasolutions

import io.reactivex.rxjava3.core.Observable

fun main() {
    val source = Observable.just(1)
    Riddle2.solve(source)

    Riddle2.solveProof(source)
}


object Riddle2 {
    /**
     * Increment each emitted value of the given [source] by 1.
     *
     * Use case: You want to transform the data.
     */
    fun solve(source: Observable<Int>): Observable<Int> = source.map { it + 1 }

    fun solveProof(source: Observable<Int>) {
        source.map { it + 1 }.subscribe { println(it) }
    }

}
