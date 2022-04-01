package app.kroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

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
fun runVariablesAndConstants() {
  var myVariable = 42
  myVariable = 50
  println("[Flow] myVariable = $myVariable")

  val myConstant = 42
  myConstant = 51
  println("[Flow] myConstant = $myConstant")
}
