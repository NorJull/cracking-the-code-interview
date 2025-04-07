package LinkedLists;

import LinkedLists.Single.Node;

/*
Given teh head of a single LinkedList reverse recursively the List.
Example:
Given:
1->2->3->4

Return:
4->3->2->1

*/
public class ReverseRecursive {

    public static void main(String[] args) {
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.next.next.next.next =     new Node(5);

        Node r = reverseCHAT_GPT(n);

        while (r != null) {
            System.out.println(r.data);
            r = r.next;
        }
    }
    private static Node reverse(Node head) {
        if(head == null || head.next == null)
            return head;
        Node prev = null;
        Node current = head;

        prev =  recursivePart(current, prev);
        return prev;
    }

    private static Node recursivePart(Node current, Node prev) {
        if(current == null)
            return prev;

        Node nextCurrent = current.next;
        current.next = prev;

        prev = current;
        current = nextCurrent;

        return recursivePart(current, prev);
    }

    // Function to reverse the linked list recursively
    public static Node reverseCHAT_GPT(Node head) {
        // Base case: If head is null or only one node, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the rest of the list
        Node rest = reverseCHAT_GPT(head.next);

        // Now set head.next.next to point to head (reverse the link)
        head.next.next = head;

        // Set head.next to null (head becomes the last node after reversal)
        head.next = null;

        // Return the new head (which is the last node of the original list)
        return rest;
    }
}
