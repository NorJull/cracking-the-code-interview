package LinkedLists;

import LinkedLists.Single.Node;

/*
Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.
The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
Write a function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input:(7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295. Output:2 -> 1 -> 9.That is,912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem. EXAMPLE
lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295. Output:9 -> 1 -> 2.That is,912.
Hints: #7, #30, #71, #95, #109


* */
public class SumLists {

    public static void main(String[] args) {
        Node n = new Node(0);
        n.next = new Node(0);
        n.next.next = new Node(6);

        Node m = new Node(0);
        m.next = new Node(0);
        m.next.next = new Node(2);

        Node head = sumList(n, m);

        Node.printList(head);
    }

    private static Node sumList(Node n, Node m) {
        if(n == null || m == null)
            return null;
        Integer sum = 0;

        sum = n.data + m.data;
        Integer nTens = 10;
        Integer mTens = 10;

        while (n.next != null || m.next != null) {
            if(n.next != null) {
                sum = sum + n.next.data * nTens;
                n = n.next;
                nTens = nTens * 10;
            }

            if(m.next != null) {
                sum = sum + m.next.data * mTens;
                m = m.next;
                mTens = mTens * 10;
            }
        }

        String sumString = String.valueOf(sum);
        // ANSI codes start from 0 = 48
        Node head = new Node(sumString.charAt(0) - 48);

        for(int i = 1; i < sumString.length(); i++) {
        Node node = new Node(sumString.charAt(i) - 48);
        node.next = head;
        head = node;
        }

        return head;
    }
}
