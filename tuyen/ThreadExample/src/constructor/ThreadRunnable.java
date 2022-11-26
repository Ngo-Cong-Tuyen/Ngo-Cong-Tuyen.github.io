package constructor;

public class ThreadRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Do something");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadRunnable());
        System.out.println("Thread has been created with name: "+ thread.getName());
        thread.start();
    }
}
