package app.kroutines

import kotlinx.coroutines.*

/*
  Launches 100K coroutines and, after 5 seconds, each coroutine prints a dot.
*/
fun run100kCoroutines() = runBlocking {
  repeat(100_000) { // launch a lot of coroutines
    launch {
      delay(5000L)
      print(".")
    }
  }
}
