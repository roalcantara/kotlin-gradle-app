package app.kroutines

import kotlinx.coroutines.*
import kotlin.system.*

/*
  Runs two suspending functions concurrently
  And prints the total time it takes to execute both suspending functions

  The [async] keyword which
    - starts a separate coroutine (a light-weight thread that works concurrently with all the other coroutines)
    - returns a deferred which is a promise of Deferred<T>.
    - provides the .await() function on a deferred value to get its eventual result.
    - is cancelable, as Deferred is also a Job.
    - is twice as fast, because the two coroutines execute concurrently.
    - should always be explicit
*/
fun runConcurrentlyUsingAsync() = runBlocking<Unit> {
  // The code in the coroutine is sequential by default
  // just like in the regular code
  val time = measureTimeMillis {
    // A normal sequential invocation
    val one = async { doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }
    println("[ConcurrentlyUsingAsync] The answer is ${one.await() + two.await()}")
  }
  println("[ConcurrentlyUsingAsync] Completed in $time ms")
}
