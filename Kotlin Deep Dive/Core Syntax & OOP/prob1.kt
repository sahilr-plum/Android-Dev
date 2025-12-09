data class Player(val username: String, var score: Int = 0, var level: Int = 1, var isReady: Boolean = true) {
    init {
        require(username.isNotBlank()) { "Username cannot be empty" }
    }
    
    fun winMatch() {
        score += 10
        println("Winner! Score is now $score")
    }
}

fun main() {
    val p1 = Player("Sahil", 0)

    println(p1.username)
    p1.score = 10

    p1.winMatch()
    p1.winMatch()

    //Immutable (doesnt have a setter)
    // p1.username = "Hacker"

    val p2 = Player("ProGamer")
    println(p2.score)

    val p3 = Player(username = "StrategyMaster", isReady = false)
    println(p3.isReady)
    println(p3.level)

    // val p4 = Player("")

    println(p1)

    val p5 = p1.copy(score = 999)
    println(p5)
}
