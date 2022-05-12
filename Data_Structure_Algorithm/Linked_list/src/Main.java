public class Main {
    public static void main(String[] args) {
        Node n1= new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        print(n1);


        n1= addAtHead(n1,0);
        print(n1);

        n1= addAtTail(n1, 4);
        print(n1);

        n1= removeValue(n1, 5);
        print(n1);
    }

    public static void print(Node headNode){
        if (headNode == null) System.out.println("linked list empty");
        else {
            Node temp = headNode;
            while (temp != null) {
                System.out.print(temp.value);
                temp= temp.next;
                if (temp != null) System.out.print("->");
            }
        }
        System.out.println();
    }

    public static Node addAtHead(Node headNode, int value){
        Node newNode = new Node(value);
        if (headNode != null) {
            newNode.next= headNode;
        }
        return newNode;
    }

    public static Node addAtTail(Node headNode, int value){
        Node newNode = new Node(value);
        if(headNode == null){
            return newNode;
        }else{
            Node lastNode = headNode;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }

            lastNode.next = newNode;
        }

        return headNode;
    }

    public static Node removeValue(Node headNode, int value){
        if (headNode==null) return null;
        if (headNode.value== value ) return headNode.next;
        Node temp= headNode;
        while (temp.next.value != value)  {
            temp= temp.next;
        }
        temp.next= temp.next.next;
        return headNode;
    }
}
