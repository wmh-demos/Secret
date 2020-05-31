package me.wayne.thread

import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock

class OddEvenPrinter2(private val limit: Int,
                      private val lock: ReentrantLock,
                      private val condition1: Condition,
                      private val condition2: Condition,
                      private val condition3: Condition) : IPrinter {

    private var initValue = 0

    override fun print() {
        lock.lock()
        while (initValue < limit) {
            val currentCondition = getCondition(initValue)

            println(String.format("线程[%s]打印数字:%d",
                    Thread.currentThread().name, ++initValue))

            if (initValue == limit) {
                condition1.signal()
                condition2.signal()
                condition3.signal()
            } else {
                val nextCondition = getCondition(initValue)
                nextCondition.signal()
                currentCondition.await()
            }
        }

        println(String.format("线程[%s] unlock", Thread.currentThread().name))
        lock.unlock()
    }

    private fun getCondition(value: Int): Condition {
        return when (value % 3) {
            0 -> {
                condition1
            }
            1 -> {
                condition2
            }
            else -> {
                condition3
            }
        }
    }
}