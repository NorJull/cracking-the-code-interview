package TreesAndGraphs;

import TreesAndGraphs.tree.binary.Node;
import TreesAndGraphs.tree.binary.search.BinarySearchTree;

/*
4.4 Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree
is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.

Hints:#21, #33, #49, #105, #124

* */
public class CheckBalanced {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(15);

        bst.insert(10);
        bst.insert(5);
        bst.insert(13);
        bst.insert(2);
        bst.insert(6);
        bst.insert(1);
        bst.insert(11);
        bst.insert(14);

        bst.insert(20);
        bst.insert(18);
        bst.insert(22);

        Node root = bst.getRoot();
        boolean r = checkBalanced(root);

        System.out.println(r);
    }

    private static boolean checkBalanced(Node root) {
        HeightValidation hv = heightValidation(root, true);
        return hv.isBalanced;
    }

    private static HeightValidation heightValidation(Node root, boolean isBalanced) {
        if(!isBalanced)
            return new HeightValidation(0, false);
        if(root == null)
            return new HeightValidation(0, true);

        HeightValidation hvl = heightValidation(root.left, true);
        if(!hvl.isBalanced)
            return new HeightValidation(0, false);
        HeightValidation hvr = heightValidation(root.right, true);
        if(!hvr.isBalanced)
            return new HeightValidation(0, false);


        if(Math.abs(hvl.height - hvr.height) > 1)
            return new HeightValidation(0, false);

        int mxh = Math.max(hvl.height, hvr.height);

        return new HeightValidation(mxh + 1, true);
    }
}

class HeightValidation {
    int height;
    boolean isBalanced = true;

    public HeightValidation(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}