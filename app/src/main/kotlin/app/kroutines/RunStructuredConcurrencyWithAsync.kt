package app.kroutines

import kotlinx.coroutines.*
import kotlin.system.*

/*
  Extract a function that concurrently performs doSomethingUsefulOne and doSomethingUsefulTwo
  and returns the sum of their results.
*/
suspend fun concurrentSum(): Int = coroutineScope {
  val one = async { doSomethingUsefulOne() }
  val two = async { doSomethingUsefulTwo() }
  one.await() + two.await()
}

/*
  Structured concurrency with async

  If something goes wrong inside the code of the concurrentSum function, and it throws an exception,
    all the coroutines that were launched in its scope will be cancelled.
*/
suspend fun runStructuredConcurrencyWithAsync() {
  val time = measureTimeMillis {
    println("[StructuredConcurrencyWithAsync] The answer is ${concurrentSum()}")
  }
  println("[StructuredConcurrencyWithAsync] Completed in $time ms")
}
