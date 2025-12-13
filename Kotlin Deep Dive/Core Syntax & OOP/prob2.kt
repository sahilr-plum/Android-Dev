sealed class NetworkResult

data class Success(val data: String): NetworkResult()
data class Failure(val error: String): NetworkResult()
data object Loading: NetworkResult()

fun processRequest(result: NetworkResult) {
    when (result) { 
        is Loading -> println("Network is loading...")
        is Success -> println("Network is resolved: ${result.data}")
        is Failure -> println("Network failed: ${result.error}")
    }
}

fun main() {
    val success = Success("This is a backend data")
    val failure = Failure("Error from server")
    val loading = Loading

    processRequest(loading)
    processRequest(success)
    processRequest(failure)
}