package TreesAndGraphs;

import TreesAndGraphs.tree.binary.BinaryTree;
import TreesAndGraphs.tree.binary.Node;

import java.util.Arrays;
import java.util.List;

/*
4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm to create
a binary search tree with minimal height.
Hints:#19, #73,#116
* */
public class MinimalTree {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);


        BinaryTree bt = createMinimalTree(numbers);
        bt.printInOrder();

        bt = createMinimalTreeBookSolution(numbers);
        bt.printInOrder();
    }
    private static BinaryTree createMinimalTree(List<Integer> numbers) {
        BinaryTree binaryTree = new BinaryTree();
        insertArrayElements(numbers, binaryTree, 0, numbers.size() -1);
        return binaryTree;
    }

    //O(N Log N)
    /*
    * All elements of array are visited ( O(N) ) and each time we call bt.insert(node) that travearse the tree (O(LogN))
    * */
    private static void insertArrayElements(List<Integer> numbers, BinaryTree binaryTree, int start, int end) {
        int numOfElements = (end - start) + 1;

        if(isEven(numOfElements)) {
            int middleIndex = ((start + end) / 2) + 1;
            binaryTree.insert(numbers.get(middleIndex));

            int numOfElementsOnTheSide = middleIndex - start;

            if(numOfElementsOnTheSide == 2) {
                //Insert the ones in the left
                binaryTree.insert(numbers.get(middleIndex - 1));
                binaryTree.insert(numbers.get(middleIndex - 2 ));
                //Insert the one in the right
                binaryTree.insert(numbers.get(middleIndex + 1));
            } else if (numOfElementsOnTheSide == 1) {
                binaryTree.insert(numbers.get(middleIndex - 1));
            } else {
                insertArrayElements(numbers, binaryTree, start, middleIndex - 1);
                insertArrayElements(numbers, binaryTree, middleIndex + 1, end);
            }

        } else {
            int middleIndex = (start + end) / 2;
            binaryTree.insert(numbers.get(middleIndex));

            int numOfElementsOnTheSide = middleIndex - start;
            if(numOfElementsOnTheSide > 1) {
                insertArrayElements(numbers, binaryTree, start, middleIndex - 1);
                insertArrayElements(numbers, binaryTree, middleIndex + 1, end);
            } else {
                binaryTree.insert(numbers.get(middleIndex - 1));
                binaryTree.insert(numbers.get(middleIndex + 1));
            }
        }

    }

    //O(N)
    private static BinaryTree createMinimalTreeBookSolution(List<Integer> numbers) {
        Node root = createMinimalBST(numbers, 0, numbers.size() - 1 );
        return new BinaryTree(root);
    }

    private static Node createMinimalBST(List<Integer> numbers, int start, int end) {
        if(end < start)
            return null;
        int mid = (start + end)  / 2;

        Node root = new Node(numbers.get(mid));

        root.setLeft(createMinimalBST(numbers, start, mid - 1));
        root.setRight(createMinimalBST(numbers, mid + 1, end));

        return root;
    }

    private static boolean isEven(int number) {
        if(number % 2 == 0)
            return true;
        return false;
    }
}
