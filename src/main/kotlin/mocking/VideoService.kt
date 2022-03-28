package mocking

import java.io.File

class VideoService {

    fun readVideoFile(): String {
        val file = File("video.txt")
        val video = convertFileToVideo(file)

        if (video == null)
            return "Error parsing video file"

        return video.title
    }

}

private fun convertFileToVideo(file: File?): Video? {
    return Video(1, "title", true)
}

data class Video(
    val id: Int,
    val title: String,
    val isProcessed: Boolean
)