package constructor;

public class ThreadString extends Thread{

    public static void main(String[] args) {
        Thread thread = new Thread("My thread name");
        thread.start();
        System.out.println("Thread has been created with name: "+ thread.getName());
    }
}
