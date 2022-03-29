package mocking


class VideoService(
    private val fileReader: Reader = FileReader(),
    private val videoRepository: IVideoRepository = VideoRepository()
) {

    fun readVideoFile(): String {
        val content = fileReader.read("video.txt")
        val video = convertFileToVideo(content)

        if (video == null)
            return "Error parsing video file"

        return video.title
    }

    fun getUnprocessedVideosAsCsv(): String {
        val ids = videoRepository.getUnprocessedVideos().map { it.id }

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