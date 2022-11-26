package deadlock;

import constructor.ThreadRunnable;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void call(Person listener) {
        System.out.println(this.name+" call to " + listener.getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        listener.listen(this);
    }
    public synchronized void listen(Person caller){
        System.out.println(this.name+ " listen "+ caller.getName());
    }

    public static void main(String[] args) {
        Person person1 = new Person("Person 1");
        Person person2 = new Person("Person 2");
        new Thread(new Runnable() {
            @Override
            public void run() {
                person1.call(person2);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                person2.call(person1);
            }
        }).start();

    }
}
