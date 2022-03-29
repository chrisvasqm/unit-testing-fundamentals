package mocking

class InstallerHelper {

    private val setupDestinationFile = ""

    fun downloadInstaller(customerName: String, installerName: String): Boolean {
        val client = WebClient()
        try {
            client.downloadFile(
                "https://example.com/$customerName/$installerName",
                setupDestinationFile
            )

            return true
        } catch (e: WebException) {
            return false
        }
    }


}

class WebException : Exception()

class WebClient {

    @Throws(WebException::class)
    fun downloadFile(url: String, destination: String)  {
        // Not needed for this example
    }

}
