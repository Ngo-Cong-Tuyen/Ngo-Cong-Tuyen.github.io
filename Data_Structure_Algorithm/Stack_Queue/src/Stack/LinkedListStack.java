//package Stack;
//
//import Queue.IStackQueue;
//import Queue.Node;
//
//public class LinkedListStack implements IStackQueue {
//
//    Node topNode;
//
//    public LinkedListStack() {
//        this.topNode = null;
//    }
//
//    @Override
//    public boolean push(int value) {
//        Node newNode = new Node(value);
//        newNode.next = topNode;
//        return true;
//    }
//
//    @Override
//    public int pop() {
//        if (isEmpty()){
//            return -1;
//        } else {
//            int value= topNode.value;
//            topNode =topNode.next;
//            return value;
//        }
//    }
//
//    @Override
//    public boolean isFull() {
//        return false;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    @Override
//    public void print() {
//
//    }
//}
