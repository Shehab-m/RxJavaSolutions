package com.projects.rxjavasolutions

import io.reactivex.rxjava3.core.Observable

fun main() {
  val source = Observable.just(0,1,1, 2, 3, 1, 1)
  Riddle7.solve(source)

  Riddle7.solveProof(source)

}

object Riddle7 {
  /**
   * When the [source] emits the same value multiple times, only allow the first value to travel downstream.
   *
   * Use case: You never want to show the same value twice.
   */
  fun solve(source: Observable<Int>): Observable<Int> = source.distinctUntilChanged()


  fun solveProof(source: Observable<Int>) {
     source.distinctUntilChanged().subscribe { println(it) }
  }

}
