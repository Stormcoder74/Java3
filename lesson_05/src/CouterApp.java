import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CouterApp {

    public static void main(String[] args) throws InterruptedException {

        Counter count = new Counter();

        for (int i = 0; i < 5; i++) {
            new Thread(new MyCounterThread(count)).start();
        }

        Thread.sleep(1000);
        System.out.println(count.count);
    }
}


class MyCounterThread implements Runnable {
    Counter counter;

    public MyCounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increase();
        }
    }
}

class Counter {

    Object obj = new Object();

    int count;
    Lock lock = new ReentrantLock();

    public Counter() {
        this.count = 0;
    }

    void increase() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    synchronized static int get() {
        return 0;
    }

}
