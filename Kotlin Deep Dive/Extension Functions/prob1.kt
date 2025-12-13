fun Long.toTimeAgo(): String {
    val now = System.currentTimeMillis()
    val difference = now - this

    val minuteInMillis = 60 * 1000

    return when {
        difference < minuteInMillis -> {
            "Just now"
        }
        difference < 60 * minuteInMillis -> {
            val minutes = difference / minuteInMillis
            "$minutes minutes ago"
        }
        else -> {
            "A long time ago"
        }
    }
}


fun main(args: Array<String>) {
    val now = System.currentTimeMillis()
    val fiveMinAgo = now - (5 * 60 * 1000)
    val twoHoursAgo = now - (2 * 60 * 60 * 1000)
    
    println(now.toTimeAgo())        // Should print: Just now
    println(fiveMinAgo.toTimeAgo()) // Should print: 5 minutes ago
    println(twoHoursAgo.toTimeAgo())// Should print: A long time ago
}