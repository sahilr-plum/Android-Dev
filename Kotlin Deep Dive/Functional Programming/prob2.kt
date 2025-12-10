// 1. Implement a function that applies an operation to each element
//    and returns the list of results along with execution time for each
fun <T, R> measureEach(
    list: List<T>,
    operation: (T) -> R
): List<Pair<R, Long>> {
    // Your code here
    // Return list of (result, timeInMillis) pairs
    return list.map {item -> 
        val startTime = System.currentTimeMillis()
        val result = operation(item)
        val endTime = System.currentTimeMillis()
        val timeTaken = endTime - startTime
        Pair(result, timeTaken)
    }
}

// 2. Implement retry logic: attempt operation up to 'times', return first success
fun <T> retryOperation(
    times: Int,
    operation: () -> T
): T? {
    // Your code here
    // Return result if successful, null if all attempts fail
    repeat(times) { 
        try {
            return operation()
        }
        catch (e: Exception) {
            
        }
    }

    return null
}

// 3. Implement a function that chains multiple transformations
fun <T> pipeline(
    initial: T,
    vararg operations: (T) -> T
): T {
    var result = initial
    for (operation in operations) {
        result = operation(result)
    }

    return result
}

// Usage example:
// val result = pipeline(
//     5,
//     { it * 2 },      // 10
//     { it + 3 },      // 13
//     { it * it }      // 169
// )

fun main() {
    // Example usage of measureEach
    val numbers = listOf(1, 2, 3, 4, 5)
    val resultsWithTime = measureEach(numbers) { it * it }
    println("Results with execution time: $resultsWithTime")

    // Example usage of retryOperation
    var attempt = 0
    val result = retryOperation(5) {
        attempt++
        if (attempt < 3) throw Exception("Failed attempt $attempt")
        "Success on attempt $attempt"
    }
    println("Retry operation result: $result")

    // Example usage of pipeline
    val pipelineResult = pipeline(
        5,
        { it * 2 },      // 10
        { it + 3 },      // 13
        { it * it }      // 169
    )
    println("Pipeline result: $pipelineResult")
}