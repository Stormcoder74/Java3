import java.util.concurrent.Semaphore;

public class Parking {

    private static final boolean[] PARKING_PLACE = new boolean[5];

    private static final Semaphore SEMAPHORE = new Semaphore(5, false);

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            new Thread(new Car(i)).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static class Car implements Runnable {

        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            System.out.println("Автомобиль № " + carNumber + " подъехал к парковке ");
            try {
                Thread.sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                SEMAPHORE.acquire();
                int parkingNumber = -1;

                synchronized (PARKING_PLACE) {
                    for (int i = 0; i < 5; i++) {
                        if (!PARKING_PLACE[i]) {
                            PARKING_PLACE[i] = true;
                            parkingNumber = i;
                            System.out.println("Машина №" + carNumber + " на месте № " + parkingNumber);
                            break;
                        }
                    }

                }
                Thread.sleep(5000);
                synchronized (PARKING_PLACE) {
                    PARKING_PLACE[parkingNumber] = false;
                }
                SEMAPHORE.release();
                System.out.println("Машина № " + carNumber + " уехала");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
