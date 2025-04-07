package LinkedLists;

import LinkedLists.Single.Node;
/*
*2.2 Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
Hints:#8, #25, #41, #67, #126
*
* */
public class ReturnKthToLast {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println(findKthToLastSlowFast(head, 0));
    }
    //O(N) time
    private static Integer findKthToLast(Node head, int kthToLast) {
        if(head == null || kthToLast <=0)
            return null;
        Node n = head;
        int size = 1;

        //Find list size
        while (n.next != null) {
            size++;
            n = n.next;
        }

        if( kthToLast > size)
            return null;

        n = head;
        // Iterate from head to the size - kthToLast 1 - 2 - 3 - 4
        for(int i = 0; i < size - kthToLast; i++) {
            n = n.next;
        }

        return n.data;
    }

    //O(N) only one pass
    private static Integer findKthToLastSlowFast(Node head, int kthToLast) {
        if(head == null || kthToLast <=0)
            return null;
        Node slow = head;
        Node fast = head;

        //Move fast to the kthToLast position
        for(int i = 1; i < kthToLast; i++) {
            if(fast.next == null)
                return null;
            fast = fast.next;
        }

        //Move fast and slow until fast reach the end
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    }
}
