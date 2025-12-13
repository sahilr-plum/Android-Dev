class DatabaseConnection {
    init {
        println("Connecting to DB...")
        Thread.sleep(2000)
    }
}

class App {
    val database: DatabaseConnection by lazy {
        DatabaseConnection()
    }
}

fun main(args: Array<String>) {
    val app = App()
    println("App Initialized")

    println("Accessing database for the first time:")
    app.database

    println("Accessing database again:")
    app.database
}