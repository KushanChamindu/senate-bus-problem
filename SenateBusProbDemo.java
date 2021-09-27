// import java.util.concurrent.*;

// Driver class
public class SenateBusProbDemo {
    public static int riders;
    public static void main(String args[]) throws InterruptedException {
        riders = 0;
        
        float bus_inter_arrival_time =  20 * 1000;
        float riders_inter_arrival_time = 2 * 1000;

        RiderGenerator riderGenerator = new RiderGenerator(riders_inter_arrival_time);
        BusGenerator busGenerator = new BusGenerator(bus_inter_arrival_time);


        riderGenerator.start();
        busGenerator.start();
    }
}