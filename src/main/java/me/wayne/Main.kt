package me.wayne

import me.wayne.file.readFileAndReadAsLine

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello IntelliJ!!!")

        calculateTotal()
    }

    private fun calculateTotal() {
        var total = 0F
        val lines = readFileAndReadAsLine("/Users/wayne/workspace/github/Secret/money.txt")
        lines.forEach {
            val index = it.indexOf("￥")
            if (index >= 0 && index < it.length - 1) {
                total += it.substring(index + 1).toFloat()
            }
        }
        println("total: $total")
    }
}