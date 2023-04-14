package machine

fun main() {

    var action: String
    val coffeeMachine = CoffeeMachine()
    do{
        println("Write action (buy, fill, take, remaining, exit): ")
        action = readln().toLowerCase()
        coffeeMachine.makeAction(action)
        
    } while(action != "exit")
}

class CoffeeMachine() {
    var waterStock = 400
    var milkStock = 540
    var coffeeBeansStock = 120
    var disposableCups = 9
    var moneyStock = 550

    fun makeAction(action: String = "") {
        when (action) {
            "buy" -> buyAction()
            "fill" -> fillAction()
            "take" -> takeAction()
            "remaining" -> printInformation()
            else -> ""
        }
    }
    
    fun printInformation() {
        println("The coffee machine has:")
        println("$waterStock ml of water")
        println("$milkStock ml of milk")
        println("$coffeeBeansStock g of coffee beans")
        println("$disposableCups disposable cups")
        println("$moneyStock of money")
    }
    
    fun buyAction() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        val option = readln()
        if (option == "back") {
            return
        }
        when(option.toInt()) {
            1 -> createEspresso()
            2 -> createLatte()
            3 -> createCappuccino()
            else -> println("Unknown buy option")
        }
    }
    
    fun createEspresso() {
        if (thereIsSufficientWater(250) 
            && thereIsSufficientCoffeeBeans(16) 
            && thereIsSufficientDisposableCups()){
            println("I have enough resources, making you a espresso!")
            waterStock -= 250
            coffeeBeansStock -= 16
            moneyStock += 4
            disposableCups--
        }
    }
    
    fun thereIsSufficientWater(waterUsed: Int): Boolean {
        if(waterStock < waterUsed){
            println("Sorry, not enough water!")
            return false
        }
        return true
    }
    
    fun thereIsSufficientCoffeeBeans(coffeeBeansUsed: Int): Boolean {
        if(coffeeBeansStock < coffeeBeansUsed){
            println("Sorry, not enough coffee beans!")
            return false
        }
        return true
    }
    
    fun thereIsSufficientDisposableCups(): Boolean {
        if(coffeeBeansStock < 1){
            println("Sorry, not enough disposable cups!")
            return false
        }
        return true
    }
    
    
    fun createLatte() {
        if (thereIsSufficientWater(350) 
            && thereIsSufficientMilk(75)
            && thereIsSufficientCoffeeBeans(20) 
            && thereIsSufficientDisposableCups()){
            println("I have enough resources, making you a latte!")
            waterStock -= 350
            milkStock -= 75
            coffeeBeansStock -= 20
            moneyStock += 7
            disposableCups--
        }
    }
    
    fun thereIsSufficientMilk(milkUsed: Int): Boolean {
        if(milkStock < milkUsed){
            println("Sorry, not enough milk!")
            return false
        }
        return true
    }
    
    fun createCappuccino() {
        if (thereIsSufficientWater(200) 
            && thereIsSufficientMilk(100)
            && thereIsSufficientCoffeeBeans(12) 
            && thereIsSufficientDisposableCups()){
            waterStock -= 200
            milkStock -= 100
            coffeeBeansStock -= 12
            moneyStock += 6
            disposableCups--
        }
    }
    
    fun fillAction() {
        println("Write how many ml of water you want to add: ")
        val addWater = readln().toInt()
        println("Write how many ml of milk you want to add: ")
        val addMilk = readln().toInt()
        println("Write how many grams of coffee beans you want to add: ")
        val addCoffeeBeans = readln().toInt()
        println("Write how many disposable cups you want to add: ")
        val addDisposableCups = readln().toInt()
        waterStock += addWater
        milkStock += addMilk
        coffeeBeansStock += addCoffeeBeans
        disposableCups += addDisposableCups
    }
    
    
    fun takeAction() {
        println("I gave you $" + moneyStock)
        moneyStock = 0
    }
}
