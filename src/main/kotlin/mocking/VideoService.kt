package mocking


class VideoService(private val fileReader: Reader) {

    fun readVideoFile(): String {
        val content = fileReader.read("video.txt")
        val video = convertFileToVideo(content)

        if (video == null)
            return "Error parsing video file"

        return video.title
    }

    fun getUnprocessedVideosAsCsv(): String {
        // Emulating a database
        val videos = listOf(
            Video(1),
            Video(2),
            Video(3),
        )

        val unprocessed = videos.filter { !it.isProcessed }
        val ids = unprocessed.map { it.id }
        return ids.joinToString(separator = ", ")
    }

}

private fun convertFileToVideo(content: String): Video? {
    return null
}

data class Video(
    val id: Int,
    val title: String = "",
    val isProcessed: Boolean = false
)