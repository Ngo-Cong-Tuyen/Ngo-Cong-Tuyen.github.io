package Queue;

public class Main {
    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

        System.out.println(queue.push(1));
        System.out.println(queue.push(2));
        System.out.println(queue.push(3));
        System.out.println(queue.push(4));
        System.out.println(queue.push(5));

        queue.print();
        System.out.println(queue.);
    }
}
