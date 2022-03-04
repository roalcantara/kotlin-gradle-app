package app.kroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*
  Use a Flow<T> to represent the stream of values that are being asynchronously computed
    - just like we would use the Sequence<T> type for synchronously computed values

  Flow is a coroutine builder
    - it uses a builder function for Flow type is called flow
    - the code inside the flow { ... } builder block can suspend
    - the fun simpleFlow() function is not marked with suspend modifier
    - the values are emitted from the flow using emit function
    - the values are collected from the flow using collect function
*/
fun simpleFlow(): Flow<Int> = flow { // flow builder
  for (i in 1..3) {
    delay(100) // pretend we are doing something useful here
    emit(i) // emit next value
  }
}

/*
  Run a flow without blocking the main thread

  It waits 100ms before printing each number

  It prints:
    [Flow] I'm not blocked 1
    [Flow] 1
    [Flow] I'm not blocked 2
    [Flow] 2
    [Flow] I'm not blocked 3
    [Flow] 3
*/
fun runStreamWithFlow() = runBlocking<Unit> {
  // Launch a concurrent coroutine to check if the main thread is blocked
  launch {
    for (k in 1..3) {
      println("[Flow] I'm not blocked $k")
      delay(100)
    }
  }

  // Collect the flow
  simpleFlow().collect { value -> println("[Flow] $value") }
}
