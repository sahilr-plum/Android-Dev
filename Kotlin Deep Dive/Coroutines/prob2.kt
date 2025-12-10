import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun getVideoStats(): String {
    println("Simulating video fetch on ${Thread.currentThread().name}")
    delay(1000)
    return "500 Views"
}

suspend fun getFollowerStats(): String {
    println("Simulating follower fetch on ${Thread.currentThread().name}")
    delay(1000)
    return "100 Followers"
}

fun main() = runBlocking {
    println("App Started!")
    
    val time1 = measureTimeMillis {
        val job = launch {
            println("Loading background data...")
            val views = getVideoStats()
            val followers = getFollowerStats()
            println("Total Views: $views")
            println("Total followers: $followers")
        }
        
        println("I am not blocked! I can show a loading spinner...")
        job.join()
    }
    
    val time2 = measureTimeMillis {
        val viewResponse = async { getVideoStats() }
        val followerResponse = async { getFollowerStats() }
        
        val views = viewResponse.await()
		val followers = followerResponse.await()
        
        println("Total Views: $views")
        println("Total followers: $followers")
    }
    
    println("Completed in $time1 ms for launch")
    println("Completed in $time2 ms for async")
}