class BankAccount(private var balance: Double = 0.0, private val pin: Int = 1234) {
    fun deposit(amount: Double) {
        balance += amount
        println("depositd $amount")
    }

    fun withdraw(amount: Double, pinToCheck: Int) {
        if(pinToCheck != pin) {
            println("Wrong PIN!")
            return
        }

        if(balance < amount) {
            println("Insufficient amount, please enter less amount!!")
            return
        }

        balance -= amount
        println("Withdrawn $amount")
    }

    fun getBalance(pinToCheck: Int) {
        if(pinToCheck != pin) {
            println("Wrong PIN!")
            return
        }

        println("Your current balance: $balance")
    }
}

fun main() {
    val sahilAccount = BankAccount()
    sahilAccount.deposit(100.0)

    // println(sahilAccount.balance)

    sahilAccount.getBalance(1234)

    sahilAccount.withdraw(50.0, 1234)
}