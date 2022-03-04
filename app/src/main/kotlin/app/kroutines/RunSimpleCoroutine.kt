package app.kroutines

import kotlinx.coroutines.*
import kotlin.system.*

/*
  A simple coroutine function

  It prints:
    [Simple Coroutine] Hello
    [Simple Coroutine] World!

  A coroutine is an instance of suspendable computation
    - it is conceptually similar to a thread - or light-weight threads
    - it is not bound to any particular thread
    - it may suspend its execution in one thread and resume in another one
    - it follow a principle of Structured Concurrency

  Structured concurrency ensures that they are not lost and do not leak
    - An outer scope cannot complete until all its children coroutines complete
    - it ensures that any errors in the code are properly reported and are never lost
    - it ensures that new coroutines can be only launched in a specific CoroutineScope

  CoroutineScope delimits the lifetime of the coroutine
    - it is a scope in which coroutines can be launched

  runBlocking is a coroutine builder
    - it blocks the current thread until all the coroutines inside the block complete their execution
    - it is often used at the very top-level of the application
    - it is quite rarely used inside the real code because:
      - threads are expensive resources
      - blocking them is inefficient and is often not desired

  launch is a coroutine builder
    - it launches a new coroutine concurrently with the rest of the code which continues to work independently
    - it can only be used inside the scope of a coroutine

  delay is a special suspending function
    - it suspends the coroutine (non-blocking) for a specific time
    - default time unit is ms

  Suspending a coroutine does not block the underlying thread
    - it allows other coroutines to run
    - and use the underlying thread for their code
*/
fun runSimpleCoroutine() = runBlocking {  // this: CoroutineScope
  launch {                                // launch a new coroutine and continue
    delay(1000L)                          // non-blocking delay for 1 second
    println("[Simple Coroutine] World!")  // --> [2] it runs after delay
  }
  // main coroutine continues while a previous one is delayed
  println("[Simple Coroutine] Hello")     // --> [1] it runs firstly!
}
