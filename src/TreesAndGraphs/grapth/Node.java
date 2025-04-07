package TreesAndGraphs.grapth;

import java.util.LinkedList;
import java.util.List;

public class Node {
    Integer value;

    List<Node> neighbors;

    public Node(Integer value) {
        this.value = value;
        neighbors = new LinkedList<>();
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    public Integer getValue() {
        return value;
    }


    public List<Node> getNeighbors() {
        return neighbors;
    }
}
