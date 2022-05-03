package org.example.thread;

public class VolatileExample implements Runnable {

    /*
    without volatile keyword, the thread does not complete as the main memory's cache (cache incoherence)
    value for 'stopRequired' does not change.
    after using volatile keyword, it makes sure the visibility
    */
    private static volatile boolean stopRequested = false;

    @Override
    public void run() {
        int i = 0;

        while (!stopRequested) {
            i++;
        }

        System.out.println("Background thread completed");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample volatileExample = new VolatileExample();

        Thread thread = new Thread(volatileExample);
        thread.start();

        Thread.sleep(1000);

        stopRequested = true;

        System.out.println("Main completed !");
    }
}
