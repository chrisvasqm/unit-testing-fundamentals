package mocking

interface Downloader {
    @Throws(WebException::class) fun downloadFile(url: String, path: String)
}