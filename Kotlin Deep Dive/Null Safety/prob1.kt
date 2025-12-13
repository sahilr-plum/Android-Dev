

class UserProfile(
    val id: Int,
    val name: String?,       // Might be null
    val bio: String?,        // Might be null
    val email: String?       // Might be null
)

val rawUsers = listOf(
    UserProfile(1, "Sahil", "Android dev", "sahil@test.com"),
    UserProfile(2, null, "Mystery user", null), // Name & Email missing
    UserProfile(3, "Alice", null, "alice@test.com"), // Bio missing
    UserProfile(4, null, null, null) // Ghost user
)

fun printUserCards(users: List<UserProfile>) {
    for (user in users) {
        println("User: ${user.name ?: "Guest"}")
        user.bio?.let {
            println("Bio: ${it}")
        }
        println("Email: ${user.email?.uppercase() ?: "NO EMAIL"}")
        println("-----")
    }
}

fun main(args: Array<String>) {
    printUserCards(rawUsers)
}