package fundamentals

class FizzBuzz {

    fun getOutput(number: Int): String {
        if (number % 3 == 0 && number % 5 == 0)
            return "FizzBuzz"
        if (number % 3 == 0)
            return "Fizz"
        if (number % 5 == 0)
            return "Buzz"

        return number.toString()
    }

}