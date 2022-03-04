package app.kroutines

import kotlinx.coroutines.*

/*
  CPU-consuming blocking code can be represented using a Sequence
*/
fun simpleSequence(): Sequence<Int> = sequence { // sequence builder
  for (i in 1..3) {
    // each computation taking 100ms
    Thread.sleep(100) // pretend we are computing it
    yield(i) // yield next value
  }
}

/*
  Outputs values in sequence waiting 100ms before each one.

  It prints:
    [Sequences] 1 after 100ms
    [Sequences] 2 after 200ms
    [Sequences] 3 after 300ms
*/
fun runSequenceIn100msEach() {
  simpleSequence().forEach { value -> println("[Sequences] $value after ${value}00ms") }
}
