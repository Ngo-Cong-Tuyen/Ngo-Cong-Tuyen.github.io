package Queue;

import java.util.ArrayList;

public class LinkedListQueue implements IStackQueue {
    Node headNode;
    Node tailNode;

    public LinkedListQueue() {
        this.headNode = null;
        this.tailNode = null;
    }


    @Override
    public boolean push(int value) {
        if (!isFull()){
            Node newNode = new Node(value);
            if (isEmpty()) {
                headNode=newNode;
                tailNode=newNode;
            }
            tailNode.next = newNode;
            tailNode = newNode;
            return  true;
        } else {
            return false;
        }
    }

    @Override
    public int peek() {
        return headNode.value;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
           return -1;
        } else {
            int value = headNode.value;
            headNode = headNode.next;
            return value;
        }
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (headNode==null);
    }

    @Override
    public void print() {
        if(isEmpty()){
            System.out.println("Queue rỗng");
        }else{
            Node temp = headNode;
            ArrayList<Integer> list = new ArrayList<>();
            while (temp != null){
                list.add(temp.value);
                temp = temp.next;
            }

            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + "\t");
            }

            System.out.println();
        }
    }
}
