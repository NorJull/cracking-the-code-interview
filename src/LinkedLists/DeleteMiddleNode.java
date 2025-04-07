package LinkedLists;

import LinkedLists.Single.Node;

/*
*2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle
* (i.e., any node but the first and last node, not necessarily the exact middle)
* of a singly linked list, given only access to that node.
EXAMPLE
lnput:the node c from the linked lista->b->c->d->e->f
Result: nothing is returned, but the new linked list looks likea->b->d->e- >f
Hints:#72
* */
public class DeleteMiddleNode {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        deleteMiddleNode(head.next.next);

        Node.printList(head);
    }
    private static boolean deleteMiddleNode(Node n) {
        if(n == null)
            return false;
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;

        return true;
    }
}
