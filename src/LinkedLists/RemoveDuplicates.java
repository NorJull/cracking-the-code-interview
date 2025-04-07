package LinkedLists;

import LinkedLists.Single.Node;

import java.util.HashMap;
import java.util.Map;

/*
2.1 Remove Dups: Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
Hints: #9, #40
* */
public class RemoveDuplicates {

    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 1 -> 2 -> 3 -> 3 -> 4 -> null
        Node head = new Node(1);
        head.next = null;


        System.out.println("Original List:");
        Node.printList(head);

        // Remove duplicates
        head = removeDuplicateWithoutBuffer(head);

        System.out.println("List after removing duplicates:");
        Node.printList(head);
    }
    //Time: O(N), Space: O(N-Duplicates)
    private static Node removeDuplicate(Node head) {
        Map<Integer, Integer> newIntegers = new HashMap<>();
        Node n = head;

        if (n == null) {
            return null;
        }

        newIntegers.put(n.data, n.data);

        while (n.next != null) {
            if(newIntegers.containsKey(n.next.data)) {
                n.next = n.next.next;
                continue;
            }

            newIntegers.put(n.next.data, n.next.data);
            n = n.next;
        }

        return head;
    }

    //Time O(N^2) The algorithm does no use extra space so O(1)
    private static Node removeDuplicateWithoutBuffer(Node head) {
        Node slow = head;
        Node fast;
        if (slow == null) {
            return null;
        }


        while(slow != null) {
            fast = slow;

            while (fast.next != null) {
                if(slow.data == fast.next.data) {
                    fast.next = fast.next.next;
                    continue;
                }
                fast = fast.next;
            }
            slow = slow.next;
        }

        return head;
    }

}
