package me.wayne.thread

import java.util.concurrent.locks.ReentrantLock

interface IPrinter {
    fun print()
}

fun testPrint() {
//    testPrint1(100)
    testPrint2(100)
}

private fun testPrint1(limit: Int) {
    val printer = OddEvenPrinter1(limit)
    val thread1 = Thread(Runnable { printer.print() }, "Thread-1")
    val thread2 = Thread(Runnable { printer.print() }, "Thread-2")
    val thread3 = Thread(Runnable { printer.print() }, "Thread-3")
    thread1.start()
    thread2.start()
    thread3.start()
    thread1.join()
    thread2.join()
    thread3.join()
    println("exit")
}

private fun testPrint2(limit: Int) {
    val lock = ReentrantLock()
    val condition1 = lock.newCondition()
    val condition2 = lock.newCondition()
    val condition3 = lock.newCondition()

    val printer = OddEvenPrinter2(limit, lock, condition1, condition2, condition3)
    val thread1 = Thread(Runnable { printer.print() }, "Thread-1")
    val thread2 = Thread(Runnable { printer.print() }, "Thread-2")
    val thread3 = Thread(Runnable { printer.print() }, "Thread-3")
    thread1.start()
    thread2.start()
    thread3.start()
    thread1.join()
    thread2.join()
    thread3.join()
    println("exit")
}