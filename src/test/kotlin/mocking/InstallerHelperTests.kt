package mocking

import com.google.common.truth.Truth.assertThat
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class InstallerHelperTests {

    private lateinit var fileDownloader: Downloader
    private lateinit var installerHelper: InstallerHelper

    @BeforeMethod
    fun setUp() {
        fileDownloader = mock()
        installerHelper = InstallerHelper(fileDownloader)
    }

    @Test
    fun downloadInstaller_IsFileDownloaded_ReturnsTrue() {
        val actual = installerHelper.downloadInstaller("customer", "installer")

        assertThat(actual).isTrue()
    }

    @Test
    fun downloadInstaller_WhenDownloadFails_ThrowsWebException() {
        whenever(fileDownloader.downloadFile(any(), any())).thenThrow(WebException::class.java)

        val actual = installerHelper.downloadInstaller("customer", "installer")

        assertThat(actual).isFalse()
    }

}