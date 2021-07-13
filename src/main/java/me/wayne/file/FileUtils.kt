package me.wayne.file

import java.io.File

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