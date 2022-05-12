package Stack;

public class ArrayStack {
    private int[] arr;
    private int size;
    private int topIndex;

    public ArrayStack(int size) {
        this.size = size;
        arr = new int[this.size];
        this.topIndex = -1;

    }

    public boolean isEmpty(){
        return topIndex < 0;
    }

    public boolean isFull(){
        return topIndex==this.size-1;
    }

    public boolean push(int value){
        if (!isFull()) {
            topIndex++;
            arr[topIndex]=value;
            return true;
        } return false;
    }

    public void print(){
        if (isEmpty()) System.out.println("Stack is empty");
        else {
            for (int i = 0; i <= topIndex; i++) {
                System.out.print(arr[i]+ " ");
            }
        }
        System.out.println();
    }

    public int pop(){
        if (isEmpty()) return -1;
        else {
            int value= arr[topIndex];
            topIndex--;
            return value;
        }
    }
}
