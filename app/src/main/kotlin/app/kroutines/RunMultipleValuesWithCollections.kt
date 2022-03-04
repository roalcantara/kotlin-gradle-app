package app.kroutines

import kotlinx.coroutines.*

/*
  Multiple values can be represented in Kotlin using collections.
*/
fun simple(): List<Int> = listOf(1, 2, 3)

/*
  Run multiple values using collections

  It prints:
    [MultipleValues] 1
    [MultipleValues] 2
    [MultipleValues] 3
*/
fun runMultipleValuesWithCollections() {
  simple().forEach { value -> println("[MultipleValues] $value") }
}
