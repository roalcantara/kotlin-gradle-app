package app.kroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simpleCancellable(): Flow<Int> = flow {
  for (i in 1..3) {
    delay(100) // delay for 100ms to simulate computation
    println("[FlowCancellation] Emitting $i")
    emit(i)
  }
}

/*
  Cancel the flow on timeout and stops executing its code

  Flow adheres to the general cooperative cancellation of coroutines.

  As usual, flow collection can be cancelled when
    - the flow is suspended in a cancellable suspending function (like delay).

  Notice how only two numbers get emitted by the flow in the simple function.

  It prints:
    [FlowCancellation] Emitting 1
    [FlowCancellation] 1
    [FlowCancellation] Emitting 2
    [FlowCancellation] 2
    [FlowCancellation] Done
*/
fun runFlowCancellation() = runBlocking<Unit> {
  withTimeoutOrNull(250) { // Timeout after 250ms
    simpleCancellable().collect { value -> println("[FlowCancellation] $value") }
  }
  println("[FlowCancellation] Done")
}
