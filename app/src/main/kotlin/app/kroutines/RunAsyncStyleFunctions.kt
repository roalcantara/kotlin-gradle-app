package app.kroutines

import kotlinx.coroutines.*
import kotlin.system.*

// The result type of somethingUsefulOneAsync is Deferred<Int>
@OptIn(DelicateCoroutinesApi::class)
fun somethingUsefulOneAsync() = GlobalScope.async {
  doSomethingUsefulOne()
}

// The result type of somethingUsefulTwoAsync is Deferred<Int>
@OptIn(DelicateCoroutinesApi::class)
fun somethingUsefulTwoAsync() = GlobalScope.async {
  doSomethingUsefulTwo()
}

/*
  Initiate async actions outside of a coroutine
    - It must involve either suspending or blocking
    - It uses `runBlocking { ... }` to block the main thread while waiting for the result

  This programming style with async functions is provided here only for illustration,
    because it is a popular style in other programming languages.

  Using this style with Kotlin coroutines is strongly discouraged.
*/
fun runAsyncStyleFunctions() { // It does not use `runBlocking`
  val time = measureTimeMillis {
    // we can initiate async actions outside of a coroutine
    val one = somethingUsefulOneAsync()
    val two = somethingUsefulTwoAsync()
    // but waiting for a result must involve either suspending or blocking.
    // here we use `runBlocking { ... }` to block the main thread while waiting for the result
    runBlocking {
      println("[AsyncStyleFunctions] The answer is ${one.await() + two.await()}")
    }
  }
  println("[AsyncStyleFunctions] Completed in $time ms")
}
