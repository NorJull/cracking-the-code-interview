package LinkedLists;

import LinkedLists.Single.Node;

import java.util.HashMap;
import java.util.Map;

/*
Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
Note that the intersection is defined based on reference, not value.That is, if the kth node of the first linked list
is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.

Hints:#20, #45, #55, #65, #76, #93, #111, #120, #129

* */
public class Intersection {

    public static void main(String[] args) {

        Node n = new Node(1);
        n.next = new Node(0);
        n.next.next = new Node(1);
        n.next.next.next = new Node(0);
        n.next.next.next.next = new Node(1);

        Node m = new Node(1);
        m.next = new Node(0);
        m.next.next = new Node(1);
        m.next.next.next = new Node(2);
        m.next.next.next.next = new Node(1);

        System.out.println(intersection(n, m));
        System.out.println(intersectionWithoutHashMap(n, m));

    }

    private static Node intersection(Node n, Node m) {
        if(n == null || m == null)
            return null;

        Map<String, String> references = new HashMap<>();

        references.put(n.toString(), n.toString());

        while (n.next != null) {
            references.put(n.next.toString(), n.next.toString());
            n = n.next;
        }

        //check in the other list if any reference match
        if(references.containsKey(m.toString()))
            return m;

        while (m.next != null) {
            if(references.containsKey(m.next.toString()))
                return m.next;
            m = m.next;
        }
        return null;
    }

    private static Node intersectionWithoutHashMap(Node nhead, Node mhead) {
        if(nhead == null || mhead == null)
            return null;

        Node n = nhead;
        Node m = mhead;

        int nLastValue = 0;
        int mLastValue = 0;
        int nSize = 1;
        int mSize = 1;

        while (n.next != null || m.next != null) {
            if(n.next != null) {
                nSize++;
                nLastValue = n.next.data;
                n = n.next;
            }

            if(m.next != null) {
                mSize++;
                mLastValue = m.next.data;
                m = m.next;
            }
        }

        if(nLastValue != mLastValue)
            return null;


        Node longest = nSize > mSize ? nhead : mhead;
        Node shortest = nSize < mSize ? nhead : mhead;
        int longestSize =  nSize > mSize ? nSize : mSize;
        int shortestSize = nSize < mSize ? nSize : mSize;

        //Move the longest pointer longestSize - shortestSize
        for(int i = 0; i < longestSize - shortestSize; i++) {
            longest = longest.next;
        }

        // check first reference
        if(longest == shortest)
            return longest;

        while (longest.next != null) {
            if(longest.next == shortest.next)
                return longest.next;

            longest = longest.next;
            shortest = shortest.next;
        }

        return null;

    }
}
