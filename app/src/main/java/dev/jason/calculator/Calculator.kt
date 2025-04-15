package dev.jason.calculator

class Calculator {
    private fun add(a: Double, b: Double) = a + b
    private fun sub(a: Double, b: Double) = a - b
    private fun multiply(a: Double, b: Double) = a * b
    private fun divide(a: Double, b: Double) =  if (b != 0.0) a / b else "Can't divide by zero"

    private val square: (Double) -> Double = { it * it }
    private val cube: (Double) -> Double = { it * it * it }

    fun calculator() {
        print("Choose an operation (add, sub, multiply, divide, square, cube): ")
        val operation = readlnOrNull()?.lowercase()

        if (operation in listOf("add", "sub", "multiply", "divide", "square", "cube")) {
            print("Enter the first number: ")
            val num1 = readln().toDouble()

            val result = when (operation) {
                "add", "sub", "multiply", "divide" -> {
                    print("Enter the second number: ")
                    val num2 = readln().toDouble()

                    when (operation) {
                        "add" -> add(num1, num2)
                        "sub" -> sub(num1, num2)
                        "multiply" -> multiply(num1, num2)
                        "divide" -> divide(num1, num2)
                        else -> 0
                    }
                }
                "square" -> square(num1)
                "cube" -> cube(num1)
                else -> 0
            }

            println("Answer: $result")
        }
    }
}