import java.util.concurrent.*;

public class SemaphoreStore {
    public static Semaphore mutex = new Semaphore(1);
    public static Semaphore multiplex = new Semaphore(10);
    public static Semaphore bus = new Semaphore(0);
    public static Semaphore allAboard = new Semaphore(0);

    public SemaphoreStore() {
    }
}
