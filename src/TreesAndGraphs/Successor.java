package TreesAndGraphs;

import TreesAndGraphs.tree.binary.Node;
import TreesAndGraphs.tree.binary.search.BinarySearchTree;

/*
4.6 Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
You may assume that each node has a link to its parent.
Hints: #79, #91
* */
public class Successor {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertWithParents(15);

        bst.insertWithParents(10);
        bst.insertWithParents(5);
        bst.insertWithParents(13);
        bst.insertWithParents(2);
        bst.insertWithParents(6);
        bst.insertWithParents(11);
        bst.insertWithParents(14);

        bst.insertWithParents(20);
        bst.insertWithParents(18);
        bst.insertWithParents(22);

        Node root = bst.getRoot();

        System.out.println(successor(root));
    }

    //O(h) where h is the height of the tree
    //This code works for BST that does not allow duplicates.
    private static Node successor(Node root) {
        if (root == null)
            return null;
        if (root.right != null) {
            Node n = root.right;
            while (n.left != null) {
                n = n.left;
            }
            return n;
        } else {
            Node n = root;

            while (n.parent != null && n.parent.value < n.value) {
                n = n.parent;
            }
            return n.parent;
        }
    }

    //O(h) where h is the height of the tree
    //This code works also for BST that allow duplicates.
    private static Node successorBookSolution(Node root) {
        if (root == null)
            return null;
        if (root.right != null) {
            Node n = root.right;
            while (n.left != null) {
                n = n.left;
            }
            return n;
        } else {
            Node parent = root;
            Node parentOfMyParent = root.parent;
            // Go up until we're on left instead of right
            while (parentOfMyParent != null && parentOfMyParent.left != parent) {
                parent = parentOfMyParent;
                parentOfMyParent = parent.parent;
            }
            return parentOfMyParent;
        }
    }
}
