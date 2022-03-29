package mocking

interface Downloader {
    @Throws(WebException::class) fun downloadFile(url: String, path: String)
}

class FileDownloader : Downloader {

    override fun downloadFile(url: String, path: String) {
        val client = WebClient()
        client.downloadFile(url, path)
    }

}