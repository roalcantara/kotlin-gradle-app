package app.kroutines

import kotlinx.coroutines.*

/*
  Uses suspend modifier
    - so that it can perform its work without blocking
    - and return the result as a list at once
*/
suspend fun simpleUsingSuspendingFunction(): List<Int> {
  delay(1000) // pretend we are doing something asynchronous here
  return listOf(1, 2, 3)
}

/*
  Prints the numbers after waiting for a second

  It prints:
    [SuspendingFunctionAndReturnList] 1 after 1sec
    [SuspendingFunctionAndReturnList] 2 after 1sec
    [SuspendingFunctionAndReturnList] 3 after 1sec
*/
fun runSuspendingFunctionAndReturnList() = runBlocking<Unit> {
  simpleUsingSuspendingFunction().forEach { value -> println("[SuspendingFunctionAndReturnList] $value after 1sec") }
}
