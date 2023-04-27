package com.projects.rxjavasolutions

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.toObservable

fun main() {
  val first = (1..5).toObservable().map { it.toInt()}
  val second = (6..10).toObservable().map { it.toInt()}
  Riddle5.solve(first,second)

  Riddle5.solveProof(first,second)

}
object Riddle5 {
  /**
   * Sum up the latest values of [first] and [second] whenever one of the Observables emits a new value.
   *
   * Use case: Two input fields in a calculator that need to be summed up and the result should be updated every time one of the inputs change.
   */
  fun solve(first: Observable<Int>, second: Observable<Int>): Observable<Int> {
    return first.zipWith(second){firstInt, secondInt -> firstInt + secondInt}
  }

  fun solveProof(first: Observable<Int>, second: Observable<Int>): Disposable {
    return first.zipWith(second){firstInt, secondInt -> firstInt + secondInt}.subscribe{ println(it) }
  }
}
