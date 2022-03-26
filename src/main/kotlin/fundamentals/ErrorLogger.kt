package fundamentals

class ErrorLogger {

    var lastError: String? = null

    fun log(error: String?) {
        if (error.isNullOrBlank())
            throw IllegalArgumentException("Error can not be null")

        lastError = error

        // write the log to storage
    }

}