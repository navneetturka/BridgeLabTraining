class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AddLinkedList {

    public static Node addTwoNumbers(Node l1, Node l2) {

        Node dummy = new Node(0); // result list start
        Node temp = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            carry = sum / 10;
            int digit = sum % 10;

            temp.next = new Node(digit);
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // 2 -> 4 -> 3
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        // 5 -> 6 -> 4
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        Node result1 = addTwoNumbers(l1, l2);
         printList(result1); 

        //9 -> 9 -> 9
        Node l3 = new Node(9);
        l3.next= new Node(9);
        l3.next.next=new Node(9);

        // 1-> 1 -> 2
        Node l4 = new Node(1);
        l4.next= new Node(1);
        l4.next.next=new Node(2);

        Node result2=addTwoNumbers(l3, l4);
        printList(result2);  
       
    }
}