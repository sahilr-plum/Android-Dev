abstract class Shape(val name: String) {
    abstract fun area(): Double

    fun display() {
        println("Displaying $name")
    }
}

class Circle(name: String, val radius: Double): Shape(name) {
    override fun area(): Double {
        val circleArea: Double = Math.PI * radius * radius
        return circleArea
    }
}

class Rectangle(name: String, val width: Double, val height: Double): Shape(name) {
    override fun area(): Double {
        val rectArea: Double = width * height
        return rectArea
    }
}

fun main() {
    val circleObj = Circle(name = "Circle", radius = 5.0)
    circleObj.display()
    println(circleObj.area())

    val rectObj = Rectangle(name = "Rectangle", width = 4.0, height = 2.0)
    rectObj.display()
    println(rectObj.area())
}