public class ChronometerThread implements Runnable {

    private Thread thread;
    private String threadName;

    public ChronometerThread(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating : " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running : " + threadName);
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(threadName + " : " + i);
                Thread.sleep(1000); // Pause for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted.");
        }
        System.out.println(threadName + " ending.");
    }

    public void start() {
        System.out.println("Creating thread object: " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

}
