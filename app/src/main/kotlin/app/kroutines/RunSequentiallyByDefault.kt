package app.kroutines

import kotlinx.coroutines.*
import kotlin.system.*

suspend fun doSomethingUsefulOne(): Int {
  delay(1000L) // pretend we are doing something useful here
  return 13
}

suspend fun doSomethingUsefulTwo(): Int {
  delay(1000L) // pretend we are doing something useful here, too
  return 29
}

/*
  Runs two suspending functions sequentially
  And prints the total time it takes to execute both suspending functions
*/
fun runSequentiallyByDefault() = runBlocking<Unit> {
  // The code in the coroutine is sequential by default
  // just like in the regular code
  val time = measureTimeMillis {
    // A normal sequential invocation
    val one = doSomethingUsefulOne()
    val two = doSomethingUsefulTwo()
    println("[Sequential by Default] The answer is ${one + two}")
  }
  println("[Sequential by Default] Completed in $time ms")
}
