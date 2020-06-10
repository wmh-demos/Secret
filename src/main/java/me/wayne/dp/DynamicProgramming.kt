package me.wayne.dp

import kotlin.math.max

val ARR = arrayListOf(1, 2, 4, 1, 7, 8, 3)

fun main() {
    println("recOpt = " + recOpt(ARR, 6))

    println("dpOpt = " + dpOpt(ARR, 6))
}

fun recOpt(arr: List<Int>, index: Int): Int {
    return when (index) {
        0 -> {
            arr[0]
        }
        1 -> {
            max(arr[0], arr[1])
        }
        else -> {
            val choose = arr[index] + recOpt(arr, index - 2)
            val giveUp = recOpt(arr, index - 1)
            max(choose, giveUp)
        }
    }
}

fun dpOpt(arr: List<Int>, index: Int): Int {
    val resultArr = mutableListOf<Int>()
    resultArr.add(0, arr[0])
    resultArr.add(1, max(arr[0], arr[1]))
    for (i in 2 until arr.size) {
        val choose = arr[i] + resultArr[i - 2]
        val giveUp = resultArr[i - 1]
        resultArr.add(i, max(choose, giveUp))
    }
    return resultArr[index]
}