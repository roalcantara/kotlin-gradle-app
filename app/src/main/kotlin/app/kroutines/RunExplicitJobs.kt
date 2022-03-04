package app.kroutines

import kotlinx.coroutines.*
import kotlin.system.*

/*
  Run an explicit job

  The coroutineScope builder creates a coroutine scope, but it also creates a job that
  can be used to explicitly wait for its completion.

  It prints:

    [Explicit Jobs] Hello,
    [Explicit Jobs] World!
    [Explicit Jobs] Done
*/
fun runExplicitJobs() = runBlocking {
  val job = launch {
    // launch a new coroutine and keep a reference to its Job
    println("[Explicit Jobs] World!")
  }
  println("[Explicit Jobs] Hello,")
  job.join() // wait until child coroutine completes
  println("[Explicit Jobs] Done")
}
