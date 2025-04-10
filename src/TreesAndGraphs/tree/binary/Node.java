package TreesAndGraphs.tree.binary;

public class Node {
    public Integer value;
    public Node left;
    public Node right;
    public Node parent;

    public Node (Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
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

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
