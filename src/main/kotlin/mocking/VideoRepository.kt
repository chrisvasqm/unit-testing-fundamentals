package mocking

class VideoRepository : IVideoRepository {

    private val videos = listOf(
        Video(1),
        Video(2),
        Video(3)
    )

    override fun getUnprocessedVideos(): Iterable<Video> = videos.filter { !it.isProcessed }

}