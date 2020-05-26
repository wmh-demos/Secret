package me.wayne.thread

interface IPrinter {
    fun print()
}

fun testPrint() {
    testPrint1(100)
}

private fun testPrint1(limit: Int) {
    val printer = OddEvenPrinter1(limit)
    val thread1 = Thread(Runnable { printer.print() }, "Thread-1")
    val thread2 = Thread(Runnable { printer.print() }, "Thread-2")
    val thread3 = Thread(Runnable { printer.print() }, "Thread-3")
    thread1.start()
    thread2.start()
    thread3.start()
    try {
        Thread.sleep(Int.MAX_VALUE.toLong())
    } catch (ignore: InterruptedException) {
    }
}

private fun testPrint2(limit: Int) {

}