package constructor;

public class ThreadNoArgs {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        System.out.println("Thread has been created with name: "+ thread.getName());
    }
}
