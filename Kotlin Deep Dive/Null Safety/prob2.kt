data class Car(var speed: Int = 0, var color: String = "White", var brand: String = "Toyota")

fun main(args: Array<String>) {
    val myCar = Car()
    
    myCar.apply { 
        speed = 100
        color = "Red"
        brand = "Ferrari"
    }

    
    // 2. Logging (Use 'also')
    myCar.also { 
        println("Car created: $myCar") 
    }

    val status = myCar.run { 
        if(speed > 80) "Fast" else "Slow"    
    }
    
    println("Status: $status")
}