import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun fetchUserData(): String {
    println("Simulating network call on: ${Thread.currentThread().name}")
    delay(1000)
    return "User: Sahil"
}

fun main() = runBlocking {
    println("App started")

    val time = measureTimeMillis {
        val job = launch {
            println("Loading background data...")
            val data = fetchUserData()
            println("Data received: $data")
        }

        println("I am not blocked! I can show a loading spinner...")

        job.join()
    }

    println("Completed in $time ms")
}