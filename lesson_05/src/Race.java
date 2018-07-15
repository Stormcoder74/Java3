import java.util.concurrent.CountDownLatch;

public class Race {
    private static final CountDownLatch START = new CountDownLatch(8);
    private static final int trackLength = 500000;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(new Car(i, (int) (Math.random() * 100) + 50)).start();
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        System.out.println("На старт!");
        START.countDown();
        Thread.sleep(1000);
        System.out.println("Внимание!");
        START.countDown();
        Thread.sleep(1000);
        System.out.println("Марш!");
        START.countDown();
    }


    private static class Car implements Runnable {

        private int carNumber;
        private int carSpeed;

        public Car(int carNumber, int carSpeed) {
            this.carNumber = carNumber;
            this.carSpeed = carSpeed;
        }

        @Override
        public void run() {
            try {
                System.out.println("Автомобиль №" + carNumber + "подъехал к старовой прямой");
                START.countDown();

                START.await();
                Thread.sleep(trackLength / carSpeed);
                System.out.println("Автомобиль № " + carNumber + " финишировал");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
