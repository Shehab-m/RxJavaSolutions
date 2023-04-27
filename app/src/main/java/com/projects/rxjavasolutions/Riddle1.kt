package com.projects.rxjavasolutions

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable

fun main() {
    val value = 5
    Riddle1.solve(value)

    Riddle1.solveProof(value)
}

object Riddle1 {
    /**
     * Transform the given [value] into an Observable that emits the value and then completes.
     *
     * Use case: You want to transform some value to the reactive world.
     */
    fun solve(value: Int): Observable<Int> = Observable.just(value)

    fun solveProof(value: Int) {
        Observable.just(value).subscribe { println(it) }
    }

}
