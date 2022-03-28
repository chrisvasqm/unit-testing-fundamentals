package mocking


class VideoService(private val fileReader: Reader) {

    fun readVideoFile(): String {
        val content = fileReader.read("video.txt")
        val video = convertFileToVideo(content)

        if (video == null)
            return "Error parsing video file"

        return video.title
    }

}

private fun convertFileToVideo(content: String): Video? {
    return null
}

data class Video(
    val id: Int,
    val title: String,
    val isProcessed: Boolean
)