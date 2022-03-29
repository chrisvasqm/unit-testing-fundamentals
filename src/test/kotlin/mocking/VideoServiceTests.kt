package mocking

import com.google.common.truth.Truth.assertThat
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class VideoServiceTests {

    private lateinit var fileReader: Reader
    private lateinit var repository: IVideoRepository
    private lateinit var service: VideoService

    @BeforeMethod
    fun setUp() {
        fileReader = mock()
        repository = mock()
        service = VideoService(fileReader, repository)
    }

    @Test
    fun readVideoTitle_EmptyFile_ReturnsError() {
        whenever(fileReader.read("video.txt")).thenReturn("")

        val actual = service.readVideoFile()

        assertThat(actual).contains("Error")
    }

    @Test
    fun getUnprocessedVideosAsCsv_AFewVideosAreUnprocessed_ReturnsAStringWithIdsSeparatedByComma() {
        whenever(repository.getUnprocessedVideos()).thenReturn(listOf(
            Video(id = 1),
            Video(id = 2),
            Video(id = 3),
        ))

        val actual = service.getUnprocessedVideosAsCsv()

        assertThat(actual).isEqualTo("1, 2, 3")
    }

    @Test
    fun getUnprocessedVideosAsCsv_AllVideosAreProcessed_ReturnAnEmptyString() {
        whenever(repository.getUnprocessedVideos()).thenReturn(listOf())

        val actual = service.getUnprocessedVideosAsCsv()

        assertThat(actual).isEqualTo("")
    }
}