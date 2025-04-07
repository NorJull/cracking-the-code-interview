package LinkedLists.Single;

public class Node {
    public Integer data;
    public Node next = null;

    public Node(Integer data) {
        this.data = data;
    }
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
