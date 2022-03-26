package fundamentals

class Math {

    fun add(a: Int, b: Int) = a + b

    fun max(a: Int, b: Int): Int = if (a > b) a else b

    fun getOddNumbers(limit: Int): MutableList<Int> {
        val odds = mutableListOf<Int>()
        for (i in 1..limit)
            if (i % 2 != 0)
                odds.add(i)

        return odds
    }
}