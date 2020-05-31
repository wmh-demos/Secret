package me.wayne.thread;

public class OddEvenPrinter1 implements IPrinter {

    private final int mLimit;
    private int mInitValue;
    private final Object mLock = new Object();

    public OddEvenPrinter1(int limit) {
        mLimit = limit;
        mInitValue = 0;
    }

    public void print() {
        while (mInitValue < mLimit) {
            synchronized (mLock) {
                System.out.println(String.format("线程[%s]打印数字:%d",
                        Thread.currentThread().getName(), ++mInitValue));
                mLock.notifyAll();

                if (mInitValue == mLimit) {
                    return;
                }

                try {
                    mLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
