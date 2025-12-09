object AppConfig {
    const val BASE_URL = "https://api.myapp.com"

    fun printUrl() {
        println("URL: $BASE_URL")
    }
}

class User(val username: String) {
    companion object {
        fun fakeUser(): User {
            return User("TestAccount")
        }
    }
}

fun main() {
    AppConfig.printUrl()

    val user = User.fakeUser()

    println("Fake user account name: ${user.username}")
}