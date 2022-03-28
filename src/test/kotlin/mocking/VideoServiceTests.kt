package mocking

import com.google.common.truth.Truth.assertThat
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class VideoServiceTests {

    private lateinit var fileReader: Reader
    private lateinit var service: VideoService

    @BeforeMethod
    fun setUp() {
        fileReader = mock()
        service = VideoService(fileReader)
    }

    @Test
    fun readVideoTitle_EmptyFile_ReturnsError() {
        whenever(fileReader.read("video.txt")).thenReturn("")

        val actual = service.readVideoFile()

        assertThat(actual).contains("Error")
    }

}