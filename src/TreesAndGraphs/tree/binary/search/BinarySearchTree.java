package TreesAndGraphs.tree.binary.search;

import TreesAndGraphs.tree.binary.Node;

public class BinarySearchTree {
    private Node root;
    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public void insert(int value) {
        root = insertRecursively(root, value);
    }

    private Node insertRecursively(Node root, int value) {
        if(root == null) {
            return new Node(value);
        }

        if(value > root.value) {
            root.right = insertRecursively(root.right, value);
        } else if (value < root.value) {
            root.left = insertRecursively(root.left, value);
        }

        return root;
    }

    public void insertWithParents(int value) {
        root = insertRecursively(root, null, value);
    }
    private Node insertRecursively(Node root, Node parent, int value) {
        if(root == null) {
            Node n = new Node(value);
            n.parent = parent;
            return n;
        }

        if(value > root.value) {
            root.right = insertRecursively(root.right, root, value);
        } else if (value < root.value) {
            root.left = insertRecursively(root.left, root, value);
        }

        return root;
    }

    public void printInOrder() {
        printInOrderRecursively(root);
    }

    private void printInOrderRecursively(Node root) {
        if(root != null) {
            printInOrderRecursively(root.left);
            System.out.println(root.value);
            printInOrderRecursively(root.right);
        }
    }

    public int height() {
        return heightRecursively(root);
    }

    private int heightRecursively(Node root) {
        if(root == null)
            return 0;

        int leftHeight = heightRecursively(root.left);
        int rightHeight = heightRecursively(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public Node getRoot() {
        return root;
    }
}
