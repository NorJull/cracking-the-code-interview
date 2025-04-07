package LinkedLists;

import LinkedLists.Single.Node;

/*
Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
to make a loop in the linked list.
EXAMPLE
Input: A -> B -> C -> D -> E -> C[the same C as earlier]
Output: C
Hints: #50, #69, #83, #90
* */
public class LoopDetection {

    public static void main(String[] args) {
        Node n = new Node(1); // 3
        n.next = new Node(2);//5
        n.next.next = new Node(3); //4
        n.next.next.next = new Node(4); //6
        n.next.next.next.next =      n.next;// 5


        System.out.println(n.next);
        System.out.println(loopDetection(n));
    }
    private static Node loopDetection(Node n) {
        if(n == null || n.next == null )
            return null;

        //Determined if is cycled
        Node slow = n;
        Node fast = n;

        Node aux;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if( slow ==  fast) {
                break;
            }
        }

        //No cycle found
        if(fast == null || fast.next == null)
            return null;

        //Find who is found first in the linked-list slow or slow.next
        slow = n;

        while (slow.next != null) {
            if(slow == fast)
                return slow;

            slow = slow.next;
            fast = fast.next;
        }

        return null;
    }
}
