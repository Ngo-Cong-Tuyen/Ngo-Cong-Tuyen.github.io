package Stack;

import Stack.ArrayStack;

public class Main {
    public static void main(String[] args) {
        ArrayStack myStack = new ArrayStack(5);
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.isFull());

        System.out.println(myStack.push(1));
        System.out.println(myStack.push(2));
        System.out.println(myStack.push(3));
        System.out.println(myStack.push(4));
        System.out.println(myStack.push(5));

        myStack.print();
        System.out.println(myStack.pop());

        myStack.push(6);
        myStack.print();
    }
}
