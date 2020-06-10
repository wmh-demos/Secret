package me.wayne.dp

import kotlin.math.max

val ARR = arrayListOf(1, 2, 4, 1, 7, 8, 3)

fun main() {
    println("recOpt1 = " + recOpt1(ARR, 6))

    println("dpOpt1 = " + dpOpt1(ARR, 6))

    println("recOpt2 = " + recOpt2(ARR, 6, 19))
}

fun recOpt1(arr: List<Int>, index: Int): Int {
    return when (index) {
        0 -> {
            arr[0]
        }
        1 -> {
            max(arr[0], arr[1])
        }
        else -> {
            val choose = arr[index] + recOpt1(arr, index - 2)
            val giveUp = recOpt1(arr, index - 1)
            max(choose, giveUp)
        }
    }
}

fun dpOpt1(arr: List<Int>, index: Int): Int {
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

fun recOpt2(arr: List<Int>, index: Int, value: Int): Boolean {
    return when {
        value == 0 -> {
            true
        }
        index == 0 -> {
            arr[index] == value
        }
        arr[index] > value -> {
            return recOpt2(arr, index - 1, value)
        }
        else -> {
            val choose = recOpt2(arr, index - 1, value - arr[index])
            val giveUp = recOpt2(arr, index - 1, value)
            choose || giveUp
        }
    }
}