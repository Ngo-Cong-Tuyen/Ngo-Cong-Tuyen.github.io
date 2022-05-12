package Queue;

public interface IStackQueue {

    boolean push(int value);
    int peek();
    int pop();
    boolean isFull();
    boolean isEmpty();
    void print();
}
