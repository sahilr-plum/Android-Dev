interface Clickable {
    fun onClick()
}

interface Focusable {
    fun onFocus() {
        println("Element gained focus")
    }
}

class Button(val label: String): Clickable, Focusable {
    override fun onClick() {
        println("Button $label clicked")
    }

    override fun onFocus() {
        println("Button $label is now focused")
    }
} 

fun main() {
    val loginButton = Button("Login")

    loginButton.onClick()
    loginButton.onFocus()
}