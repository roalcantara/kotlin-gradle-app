package app.kroutines

import kotlinx.coroutines.*
import kotlin.system.*

/*
  Runs Multiple Concurrent Operations

  A coroutineScope builder
    - can be used inside any suspending function to perform multiple concurrent operations
    - can called from any suspending function
    - just suspends - rather than blocking - the execution of the coroutine,
      releasing the underlying thread for other usages

  It prints:
    [Concurrent Operations] Hello
    [Concurrent Operations] World 1
    [Concurrent Operations] World 2
*/
suspend fun runMultipleConcurrentOperations() = coroutineScope { // Creates a coroutine scope
  // Concurrently executes both launch sections
  launch {
    delay(2000L)
    println("[Concurrent Operations] World 2") // prints after delay
  }
  launch {
    delay(1000L)
    println("[Concurrent Operations] World 1") // printed first
  }
  println("[Concurrent Operations] Hello") // main coroutine continues while a previous one is delayed
}
