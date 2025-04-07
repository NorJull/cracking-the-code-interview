package LinkedLists;

import LinkedLists.Single.Node;

/*
Given teh head of a single LinkedList reverse the List.
Example:
Given:
1->2->3->4

Return:
4->3->2->1

*/
public class ReverseSingleLinkedList {

    public static void main(String[] args) {
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.next.next.next.next =     new Node(5);

        Node r = reverse(n);

        while (r != null) {
            System.out.println(r.data);
            r = r.next;
        }

    }
    private static Node reverse(Node head) {
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
        }
        return prev;
    }
}
