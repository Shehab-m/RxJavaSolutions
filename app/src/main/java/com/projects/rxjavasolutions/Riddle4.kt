package com.projects.rxjavasolutions

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.toObservable

fun main() {
    val source = (1..10).toObservable().map {  }
    Riddle4.solve(source)

    Riddle4.solveProof(source)

}

object Riddle4 {
    /**
     * Implement a toggle mechanism. Initially we want to return false.
     * Every time [source] emits, we want to negate the previous value.
     *
     * Use case: Some button that can toggle two states. For instance a switch between White & Dark theme.
     */
    fun solve(source: Observable<Unit>): Observable<Boolean> {
        return source.scan(false) { prev, _ -> !prev }
    }

    fun solveProof(source: Observable<Unit>) {
        source.scan(false) { prev, unit -> !prev }.subscribe { println(it) }
    }
}
