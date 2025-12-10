import kotlinx.coroutines.*

suspend fun processImage() = withContext(Dispatchers.Default) {
    println("Processing image on thread: ${Thread.currentThread().name}")
    delay(500)
}

fun main() {
    runBlocking {
        println("Start on: ${Thread.currentThread().name}")

        launch {
            processImage()
            println("Back on: ${Thread.currentThread().name}")
        }
    }
}
