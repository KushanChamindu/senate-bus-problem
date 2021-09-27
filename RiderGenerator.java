import java.util.Random;

public class RiderGenerator extends Thread {

    private float arrivalMeanTime;
    private static Random random;

    public RiderGenerator(float arrivalMeanTime) {
        this.arrivalMeanTime = arrivalMeanTime;
        random = new Random();
    }

    @Override
    public void run() {

        int riderIndex = 1;
        while (!Thread.currentThread().isInterrupted()) {
            
            try {
                float next_rider_time = getArrivalTime();
                System.out.println("Rider - "+riderIndex+ " arrived ----------next rider will arrive after "+ next_rider_time+ "miliseconds");
                Rider rider = new Rider(SemaphoreStore.mutex, SemaphoreStore.bus, SemaphoreStore.allAboard,SemaphoreStore.multiplex, "Rider_"+String.valueOf(riderIndex));
                rider.start();

                riderIndex++;
                Thread.sleep(getArrivalTime());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long getArrivalTime() {
        float lambda = 1 / arrivalMeanTime;
        return Math.round(-Math.log(1 - random.nextFloat()) / lambda);
    }
}
