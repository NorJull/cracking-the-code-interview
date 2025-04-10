package TreesAndGraphs;

import TreesAndGraphs.tree.binary.Node;
import TreesAndGraphs.tree.binary.search.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/*
4.5 Validate BST: Implement a function to check if a binary tree is a binary search tree.
Hints: #35, #57, #86, #113, #128
* */
public class ValidateBST {

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

        root.left.value = 21;
        System.out.println(validateBST(root));

    }
    private static boolean validateBST(Node root) {
        List<Integer> numbers = new ArrayList<>();
        return checkInOrderBoolean(root, numbers);
    }

    private static boolean checkInOrderBoolean(Node root, List<Integer> numbers) {
        if(root != null) {
            if(!checkInOrderBoolean(root.left, numbers))
                return false;

            numbers.add(root.value);

            if(numbers.size() >= 2) {
                if(numbers.get(numbers.size() - 2) >= numbers.get(numbers.size() - 1))
                    return false;
            }

            if(!checkInOrderBoolean(root.right, numbers))
                return false;
        }
        return true;
    }
}
