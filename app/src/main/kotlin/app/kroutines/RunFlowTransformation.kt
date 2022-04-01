package app.kroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun performRequest(request: Int): String {
  delay(1000) // imitate long-running asynchronous work
  return "response $request"
}

/*
  Transform a flow Flows with operators

  There are other builders for easier declaration of flows:
    - flowOf builder that defines a flow emitting a fixed set of values.
    - Various collections and sequences can be converted to flows using .asFlow() extension functions.
*/
fun runFlowTransformation() = runBlocking<Unit> {
  (1..3).asFlow() // a flow of requests
    .map { request -> performRequest(request) }
    .collect { response -> println(response) }
}
