package TreesAndGraphs.tree.binary;

public class Node {
    Integer value;
    Node left;
    Node right;

    public Node (Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
