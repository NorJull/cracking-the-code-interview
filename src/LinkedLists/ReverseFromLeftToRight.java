package LinkedLists;

import LinkedLists.Single.Node;

/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list
from position left to position right, and return the reversed list.
* */
public class ReverseFromLeftToRight {

    public static void main(String[] args) {
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.next.next.next.next =     new Node(5);

        Node r = reverseBetween(n, 2, 4);

        while (r != null) {
            System.out.println(r.data);
            r = r.next;
        }

    }

    private static Node reverseBetween(Node head, int left, int right) {
        if(left == right)
            return head;

        if(head.data == left) {
            // Head is the  left
            Node prevToLeft = head;
            Node reversed = reverseUpToRight(prevToLeft, right);
            return reversed;
        }

        Node prevToLeft = head;

        while(prevToLeft.next != null) {
            if(prevToLeft.next.data == left)
                break;
            prevToLeft = prevToLeft.next;
        }

        Node reversed = reverse(prevToLeft.next, right);

        prevToLeft.next = reversed;

        return head;

    }

    //Time: O(N)
    //Space O(1)
    private static Node reverse(Node head, int right) {
        Node first = head;

        if(head == null)
            return head;

        if(head.next == null)
            return head;

        Node prev = null;
        Node current = head;

        while(current.next != null) {
            Node nextCurrent = current.next;
            current.next = prev;
            prev = current;
            current = nextCurrent;

            if(current.data == right) {
                first.next = current.next;
            }
        }
        return prev;
    }


    //Time: O(N)
    //Space O(N)
    private static Node reverseUpToRight(Node head, int right) {
        Node headReverse = new Node(head.data);
        Node left = headReverse;

        while (head.next != null) {
            //Changing the head with a new Object
            Node aux = new Node(head.next.data);
            aux.next = headReverse;
            headReverse = aux;

            if(head.next.data == right) {
                left.next = head.next.next;
                break;
            }

            head = head.next;
        }

        return headReverse;
    }
}
