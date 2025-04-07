package TreesAndGraphs;

import TreesAndGraphs.grapth.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
4.1 Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
Hints:#127
* */
public class RouteBetweenNodes {

    public static void main(String[] args) {
        Node UNO = new Node(1);
        Node DOS = new Node(2);
        Node TRES = new Node(3);
        Node CUATRO = new Node(4);
        Node CINCO = new Node(5);
        Node SEIS = new Node(6);

        UNO.addNeighbor(CUATRO);
        UNO.addNeighbor(CINCO);
        UNO.addNeighbor(SEIS);

        CINCO.addNeighbor(DOS);
        CINCO.addNeighbor(SEIS);

        DOS.addNeighbor(TRES);

        System.out.println(routeBetweenNodes(UNO, TRES));
    }

    private static boolean routeBetweenNodes(Node A, Node B) {
        if(A == null || B == null)
            throw new RuntimeException("Nodes can not be null.");

        Map<Integer, Integer> visitedNodes = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(A);
        visitedNodes.put(A.getValue(), A.getValue());

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if(current.getValue().equals(B.getValue()))
                return true;

            current.getNeighbors().forEach(neighbor -> {
                if(!visitedNodes.containsKey(neighbor.getValue())) {
                    queue.add(neighbor);
                    visitedNodes.put(neighbor.getValue(), neighbor.getValue());
                }
            });

        }

        return false;
    }
}
