/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package app

import kotlinx.coroutines.*
import app.kroutines.*

class App {
  val greeting: String
    get() {
      return "Hello World!"
    }
}

/*
  The main function is the entry point for the application.

  runBlocking
    - it means that the thread that runs it (in this case — the main thread)
      gets blocked for the duration of the call, until all the coroutines inside
      runBlocking { ... } complete their execution.

  launch is a coroutine builder
    - it launches a new coroutine concurrently with the rest of the code which continues to work independently
    - it can only be used inside the scope of a coroutine
*/
fun main() = runBlocking {
  println(App().greeting)
  runSimpleCoroutine()
  launch { runSuspendingFunction() }
  println("[Main] Hello")
  runCoroutineScopedFunction()
  runMultipleConcurrentOperations()
  runExplicitJobs()
  runSequentiallyByDefault()
  runConcurrentlyUsingAsync()
  runLazilyStartedAsync()
  runAsyncStyleFunctions()
  runStructuredConcurrencyWithAsync()
  runFailedConcurrent()
  runCoroutineDispatchers()
  runMultipleValuesWithCollections()
  run100kCoroutines()
}
