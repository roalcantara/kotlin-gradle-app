package app.kroutines

import kotlinx.coroutines.*
import kotlin.system.*

/*
  Cancell both the first async and the awaiting parent on failure of one of the children

  Cancellation is always propagated through coroutines hierarchy.

  It prints:
    [FailedConcurrent] Second child throws an exception
    [FailedConcurrent] First child was cancelled
    [FailedConcurrent] Computation failed with ArithmeticException
*/
fun runFailedConcurrent() = runBlocking<Unit> {
  try {
    failedConcurrentSum()
  } catch(e: ArithmeticException) {
    println("[FailedConcurrent] Computation failed with ArithmeticException")
  }
}

suspend fun failedConcurrentSum(): Int = coroutineScope {
  val one = async<Int> {
    try {
      delay(Long.MAX_VALUE) // Emulates very long computation
      42
    } finally {
      println("[FailedConcurrent] First child was cancelled")
    }
  }
  val two = async<Int> {
    println("[FailedConcurrent] Second child throws an exception")
    throw ArithmeticException()
  }
  one.await() + two.await()
}
