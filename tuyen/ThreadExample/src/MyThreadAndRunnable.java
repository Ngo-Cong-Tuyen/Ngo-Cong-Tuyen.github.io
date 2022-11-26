public class MyThreadAndRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("My thread implements runnable is running...");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThreadAndRunnable());
        thread.start();
    }
}
