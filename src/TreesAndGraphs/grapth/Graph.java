package TreesAndGraphs.grapth;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Graph {
    /*
    key -> Name of the Node
    value -> actual Value
    * */
    private Map<Integer, Node> nodeMap;

    public Graph() {
        nodeMap = new HashMap<>();
    }

    public void addNode(Integer value) {
        nodeMap.putIfAbsent(value, new Node(value));
    }

    public void addEdge(Integer from, Integer to) {
        if(from == null || to == null)
            throw new RuntimeException("Edge nodes should not be null.");

        Node nodeFrom = nodeMap.get(from);
        Node nodeTo = nodeMap.get(to);

        if(nodeFrom != null && nodeTo != null)
            nodeFrom.addNeighbor(nodeTo);
    }

    public void print() {
        for(Node node : nodeMap.values()) {
            System.out.print(node.value + ": -> ");
            String neighbors = node.neighbors
                    .stream()
                    .map( n -> n.value.toString()).collect(Collectors.joining(","));
            System.out.print(neighbors);
            System.out.println();
        }
    }
}
