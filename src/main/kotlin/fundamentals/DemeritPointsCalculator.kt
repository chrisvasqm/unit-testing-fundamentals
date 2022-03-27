package fundamentals

class DemeritPointsCalculator {

    private val speedLimit = 65

    fun calculateDemeritPoints(speed: Int): Int {
        if (speed < 0)
            throw IllegalArgumentException("Speed must be a positive value")

        if (speed <= speedLimit)
            return 0

        val kmPerDemeritPoint = 5

        return (speed - speedLimit) / kmPerDemeritPoint
    }

}