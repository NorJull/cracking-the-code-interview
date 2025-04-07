package StacksAndQueues;

import java.util.NoSuchElementException;
import java.util.Stack;

/*
3.4 Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
Hints: #98, #114
* */
public class QueueViaStacks<T> {


    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueViaStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void add(T value) {
        stack1.push(value);
    }

    public T remove() {
        if(stack1.isEmpty() && stack2.isEmpty())
            throw new NoSuchElementException();

        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                T element = stack1.pop();
                stack2.push(element);
            }
        }
        return stack2.pop();
    }

    public T peek() {
        if(stack1.isEmpty() && stack2.isEmpty())
            throw new NoSuchElementException();

        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                T element = stack1.pop();
                stack2.push(element);
            }
        }
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
