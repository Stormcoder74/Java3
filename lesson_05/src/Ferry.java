import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Ferry {

    private static final CyclicBarrier BARRIER = new CyclicBarrier(3, new FerryBoat());

    public static void main(String[] args) throws InterruptedException{
        for (int i = 0; i <9 ; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(500);
        }
    }

    private static class FerryBoat implements Runnable{
        @Override
        public void run() {
            try{
                Thread.sleep(500);
                System.out.println("Паром переправил автомобили");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private static class Car implements Runnable{
        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            System.out.println("Автомобиль № "+carNumber+" подъехал к паромной переправе");
            try {
                BARRIER.await();
                System.out.println("Автомобиль № "+carNumber+" продолжил движение");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
