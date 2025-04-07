package StacksAndQueues;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

/*
3.5 Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use an additional
temporary stack, but you may not copy the elements into any other data structure (such as an array). The stack supports
the following operations: push, pop, peek, and isEmpty.

Hints:# 15, #32, #43
* */
public class SortStack {

    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();

        l.add(1);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(0);
        stack.push(3);
        sort(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
    private static void sort(Stack<Integer> stack) {
        if(stack.isEmpty())
            throw new EmptyStackException();

        Stack<Integer> aux = new Stack<>();
        boolean readyToSort = false;


        while(!readyToSort) {
            aux.push(stack.pop());
            Integer minorNumberFound = null;

            while (!stack.isEmpty()) {
                if (stack.peek() >= aux.peek()) {
                    aux.push(stack.pop());
                    if (stack.isEmpty())
                        readyToSort = true;
                } else {
                    minorNumberFound = stack.pop();
                    if (stack.isEmpty())
                        readyToSort = true;
                    break;
                }
            }

            while (!aux.isEmpty()) {
                if (minorNumberFound != null && minorNumberFound > aux.peek()) {
                    stack.push(Integer.valueOf(minorNumberFound));
                    minorNumberFound = null;
                } else {
                    stack.push(aux.pop());
                }
            }

            if (minorNumberFound != null) {
                stack.push(Integer.valueOf(minorNumberFound));
            }

        }

    }

    private static void sortBookSolution(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty()) {
            /* Insert each element in s in sorted order into r. */
            int tmp = s.pop();
            while(!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        /* Copy the elements from r back into s. */
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }
}
