package app.kroutines

import kotlinx.coroutines.*
import kotlin.system.*

/*
  Runs suspending function using coroutineScope

  coroutineScope is a Scope builder.
    - it creates a coroutine scope and does not complete until all launched children complete
    - it just suspends - rather than block - the current thread for waiting
      releasing the underlying thread for other usages.
    - it is a suspending function - while runBlocking is a regular function
    - it can be used from any suspending function

  It prints:
    [Coroutine Scoped] Hello
    [Coroutine Scoped] World!
*/
suspend fun runCoroutineScopedFunction() = coroutineScope {  // this: CoroutineScope
  launch {
      delay(500L)
      println("[Coroutine Scoped] World!")
  }
  println("[Coroutine Scoped] Hello")
}
