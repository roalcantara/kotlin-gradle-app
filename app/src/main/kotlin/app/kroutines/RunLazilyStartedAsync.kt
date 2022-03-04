package app.kroutines

import kotlinx.coroutines.*
import kotlin.system.*

/*
  Runs two suspending functions concurrently lazily

  Two coroutines are defined but NOT imediatally executed
  It starts the execution when the start() function is called

  Note that if we just call await in println without first calling start on individual coroutines,
  this will lead to sequential behavior - which is not the intended use-case for laziness.

  The use-case for async(start = CoroutineStart.LAZY) is a replacement for the standard lazy function
  in cases when computation of the value involves suspending functions.
*/
fun runLazilyStartedAsync() = runBlocking<Unit> {
  val time = measureTimeMillis {
    // A normal sequential invocation
    val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
    val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
    println("[LazilyStartedAsync] What?") // some computation
    one.start() // We first start one
    two.start() // then start two
    println("[LazilyStartedAsync] The answer is ${one.await() + two.await()}") // then await for the individual coroutines to finish.
  }
  println("[LazilyStartedAsync] Completed in $time ms")
}
