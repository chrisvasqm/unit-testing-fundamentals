package mocking

import java.io.File

class FileReader : Reader {

    override fun read(path: String): String {
        return File(path).readText()
    }

}