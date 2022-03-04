package app.kroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*
  It returns quickly and does not wait for anything.

  Flows are cold streams similar to sequences
    - the flow starts every time it is collected.
    - that is why it is NOT marked as suspend.
*/
fun simpleCold(): Flow<Int> = flow {
  println("[FlowWhenCollect] Flow started")
  for (i in 1..3) {
      delay(100)
      emit(i)
  }
}

/*
  Runs the code inside a flow builder only when the flow is collected.

  It prints:
    [FlowWhenCollect] Calling simple function...
    [FlowWhenCollect] Calling collect...
    [FlowWhenCollect] Flow started
    [FlowWhenCollect] 1
    [FlowWhenCollect] 2
    [FlowWhenCollect] 3
    [FlowWhenCollect] Calling collect again...
    [FlowWhenCollect] Flow started
    [FlowWhenCollect] 1
    [FlowWhenCollect] 2
    [FlowWhenCollect] 3
*/
fun runFlowWhenCollect() = runBlocking<Unit> {
  println("[FlowWhenCollect] Calling simple function...")
  val flow = simpleCold()
  println("[FlowWhenCollect] Calling collect...")
  flow.collect { value -> println("[FlowWhenCollect] $value") }
  println("[FlowWhenCollect] Calling collect again...")
  flow.collect { value -> println("[FlowWhenCollect] $value") }
}
