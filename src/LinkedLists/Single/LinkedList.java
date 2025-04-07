package LinkedLists.Single;

public class LinkedList {
    private Node head;


    public Node add(Integer data) {
        if(head == null) {
            head = new Node(data);
            return head;
        }
        Node n = head;
        Node newNode = new Node(data);

        while (head.next != null) {
            n = n.next;
        }

        n.next = newNode;
        return head;
    }

    public Node getHead() {
        return head;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(head.data);
        Node n = head;

        while (n.next != null) {
            n = n.next;
            sb.append(" " + n.data);
        }

        return sb.toString();
    }
}
