package mocking

class FileDownloader : Downloader {

    override fun downloadFile(url: String, path: String) {
        val client = WebClient()
        client.downloadFile(url, path)
    }

}