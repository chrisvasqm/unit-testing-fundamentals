package mocking

class InstallerHelper(private val downloader: Downloader) {

    private val setupDestinationFile = ""

    fun downloadInstaller(customerName: String, installerName: String): Boolean {
        try {
            downloader.downloadFile(
                "https://example.com/$customerName/$installerName",
                setupDestinationFile
            )

            return true
        } catch (exception: WebException) {
            // Here we would log the exception
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
