package constructor;

public class ThreadRunnableString implements Runnable{
    @Override
    public void run() {
        System.out.println("Do something new");
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadRunnableString(),"New Thread Name");
        System.out.println("Thread has been created with name: "+ thread.getName());
        thread.start();
    }
}
