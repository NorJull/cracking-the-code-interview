package LinkedLists;

import LinkedLists.Single.Node;

/*
*2.4 Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
*    before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
*  to be after the elements less than x (see below). The partition element x can appear anywhere in the "right partition";
*    it does not need to appear between the left and right partitions.
EXAMPLE
Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1[partition=5]
Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
Hints: #3, #24
* */
public class Partition {

    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(1);
        list.next.next = new Node(1);
        list.next.next.next = new Node(1);
        list.next.next.next.next = new Node(10);
        list.next.next.next.next.next = new Node(2);
        list.next.next.next.next.next.next = new Node(1);

        Node n = partition(list, 5);

        Node.printList(n);
    }
    private static Node partition(Node head, Integer x) {
        if(head == null)
            return null;
        Node n = head;

        while (n.next != null) {
            if(n.next.data < x ) {
                Node aux = n.next;
                n.next = n.next.next;
                aux.next = head;
                head = aux;
                continue;
            }
            n = n.next;
        }
        return head;
    }
}
