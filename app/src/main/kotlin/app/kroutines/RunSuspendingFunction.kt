package app.kroutines

import kotlinx.coroutines.*
import kotlin.system.*

/*
  Runs a Suspending Function

  Suspending function is a function that can suspend its execution
    - it can called from any suspending function
    - it can be used inside any suspending function to perform multiple concurrent operations
    - it can use other suspending functions - like delay()

  delay() is a special suspending function
    - it suspends the coroutine (non-blocking) for a specific time
    - default time unit is ms

  Suspending a coroutine does not block the underlying thread
    - it allows other coroutines to run
    - and use the underlying thread for their code

  It prints:
    [Suspending Function] World!
*/
suspend fun runSuspendingFunction() {
  delay(1000L)
  println("[Suspending Function] World!")
}
