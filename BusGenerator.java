import java.util.Random;

public class BusGenerator extends Thread {

    private float arrivalMeanTime;
    private static Random random;

    public BusGenerator(float arrivalMeanTime) {
        this.arrivalMeanTime = arrivalMeanTime;
        random = new Random();
    }

    @Override
    public void run() {

        int busIndex = 1;
        while (!Thread.currentThread().isInterrupted()) {
            

            try {
                long next_depart_time = getBusInterArrivalTime();
                System.out.println("Bus - "+busIndex+ " arrived ----------next bus will depart after "+ next_depart_time+ "miliseconds");
                Bus bus = new Bus(SemaphoreStore.mutex, SemaphoreStore.bus, SemaphoreStore.allAboard, "Bus_"+String.valueOf(busIndex));
                bus.start();

                busIndex++;

                Thread.sleep(next_depart_time);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All buses have finished arriving");
    }

    public long getBusInterArrivalTime() {
        float lambda = 1 / arrivalMeanTime;
        return Math.round(-Math.log(1 - random.nextFloat()) / lambda);
    }
}