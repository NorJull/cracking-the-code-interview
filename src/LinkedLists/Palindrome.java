package LinkedLists;

import LinkedLists.Single.Node;

/*
Palindrome: Implement a function to check if a linked list is a palindrome.
Hints:#5, #13, #29, #61, #101
* */
public class Palindrome {

    public static void main(String[] args) {
        Node n = new Node(1);
        n.next = new Node(0);
        n.next.next = new Node(1);
        n.next.next.next = new Node(0);
        n.next.next.next.next = new Node(1);

        System.out.println(palindrome(n));
    }

    private static boolean palindrome(Node head) {
        if(head == null)
            return false;
        Node n = head;
        Node reverseList = new Node(head.data);

        while (n.next != null) {
            Node aux = new Node(n.next.data);
            aux.next = reverseList;
            reverseList = aux;

            n = n.next;
        }

        //Check first
        n = head;
        if (reverseList.data != n.data)
            return false;

        while (n.next != null) {
           if(n.next.data != reverseList.next.data)
               return false;

           n = n.next;
           reverseList = reverseList.next;
        }

        return true;
    }
}
