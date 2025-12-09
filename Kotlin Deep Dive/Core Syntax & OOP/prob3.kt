open class Notification(val message: String) {
    open fun send() {
        println("Sending generic notification: $message")
    }
}

class EmailNotification(val senderEmail: String, message: String): Notification(message) {
    override fun send() {
        println("Email from $senderEmail: $message")
    }
}

fun main() {
    val emailNotify = EmailNotification("connectwithsahil007@gmail.com", "Hi, how are you!")

    emailNotify.send()
}