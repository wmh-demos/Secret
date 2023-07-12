package me.wayne.file

import okio.buffer
import okio.sink
import okio.source
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

@Throws(FileNotFoundException::class, IOException::class)
fun readFileAndReadAsLineV2(dir: String): MutableList<String> {
    val result = mutableListOf<String>()
    File(dir).source().use { source ->
        source.buffer().use {
            while (true) {
                val line = it.readUtf8Line() ?: break
                result.add(line)
            }
        }
    }
    return result
}

@Throws(FileNotFoundException::class, IOException::class)
fun writeFile(file: File?, content: String?) {
    if (file == null || content == null) {
        return
    }

    file.sink().use { sink ->
        sink.buffer().writeUtf8(content)
    }
}

fun readFileAndReadAsLine(dir: String): MutableList<String> {
    val result = mutableListOf<String>()
    File(dir).bufferedReader().forEachLine {
        result.add(it.trim())
    }
    return result
}

fun loadDirSubFiles(dir: String): Array<out File>? {
    val dirFile = File(dir)
    return dirFile.listFiles()
}

fun loadDirSubFileNames(dir: String): List<String> {
    val fileList = loadDirSubFiles(dir) ?: return emptyList()
    return fileList.map { it.name }
}