package TreesAndGraphs;



import TreesAndGraphs.tree.binary.Node;
import TreesAndGraphs.tree.binary.search.BinarySearchTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
4.3 List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
(e.g., if you have a tree with depth D, you'll have D linked lists).
Hints: #107, #123, #135
* */
public class ListOfDepths {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(15);

        bst.insert(10);
        bst.insert(5);
        bst.insert(13);
        bst.insert(2);
        bst.insert(6);
        bst.insert(11);
        bst.insert(14);

        bst.insert(20);
        bst.insert(18);
        bst.insert(22);

        Node root = bst.getRoot();
        Map map = listOfDepth(root);

        System.out.println(map);
    }

    private static Map<Integer, LinkedList<Integer>> listOfDepth(Node root) {
        Map<Integer, LinkedList<Integer>> listOfDepth = new HashMap<>();
        int depth = 1;

        createListByDepth(root, depth, listOfDepth);

        return listOfDepth;
    }

    private static void createListByDepth(Node root, int depth, Map<Integer, LinkedList<Integer>> listOfDepth) {
        if(root == null)
            return;

        if(!listOfDepth.containsKey(depth))
            listOfDepth.put(depth, new LinkedList<>());

        listOfDepth.get(depth).add(root.value);
        depth++;

        createListByDepth(root.left, depth, listOfDepth);
        createListByDepth(root.right, depth, listOfDepth);
    }
}
