package app.kroutines

import kotlinx.coroutines.*

/*
  Use coroutine dispatcher to run a job on a specific thread

  All coroutine builders like launch and async accept an optional CoroutineContext parameter
    - that can be used to explicitly specify the dispatcher for the new coroutine and other context elements.

  CoroutineDispatcher
    - it determines what thread or threads the corresponding coroutine uses for its execution
    - it can confine coroutine execution to:
      - a specific thread
      - dispatch it to a thread pool
      - let it run unconfined

  It prints:
    [CoroutineDispatchers] Unconfined            : I'm working in thread main
    [CoroutineDispatchers] Default               : I'm working in thread DefaultDispatcher-worker-1
    [CoroutineDispatchers] newSingleThreadContext: I'm working in thread MyOwnThread
    [CoroutineDispatchers] main runBlocking      : I'm working in thread main
*/
suspend fun runCoroutineDispatchers() = runBlocking<Unit> {
  // without parameters, inherits the context (and thus dispatcher) from the CoroutineScope it is being launched from.
  launch { // context of the parent, main runBlocking coroutine
    println("[CoroutineDispatchers] main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
  }
  // a special dispatcher that also appears to run in the main thread
  launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
    println("[CoroutineDispatchers] Unconfined            : I'm working in thread ${Thread.currentThread().name}")
  }
  // used when no other dispatcher is explicitly specified in the scope
  // and uses a shared background pool of threads.
  launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
    println("[CoroutineDispatchers] Default               : I'm working in thread ${Thread.currentThread().name}")
  }
  // creates a thread for the coroutine to run on
  launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
    // A dedicated thread is a very expensive resource.
    // In a real application it must be either released, when no longer needed,
    // using the close function, or stored in a top-level variable and reused throughout the application.
    println("[CoroutineDispatchers] newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
  }
}
