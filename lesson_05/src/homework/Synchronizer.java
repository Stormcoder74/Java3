package homework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Synchronizer {
    public CountDownLatch ready;
    public CountDownLatch start;
    public CyclicBarrier finish;

    public Synchronizer(int ready, int start, int finish) {
        this.ready = new CountDownLatch(ready);
        this.start = new CountDownLatch(start);
        this.finish = new CyclicBarrier(finish);
    }
}
