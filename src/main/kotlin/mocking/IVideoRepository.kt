package mocking

interface IVideoRepository {
    fun getUnprocessedVideos(): Iterable<Video>
}