public class ThreadPriority extends Thread{

    public void run() {
        System.out.println("running thread priority is: "+ Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        Thread thread1 = new ThreadPriority();
        Thread thread2 = new ThreadPriority();
        Thread thread3 = new ThreadPriority();
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread3.setPriority(ThreadPriority.NORM_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
