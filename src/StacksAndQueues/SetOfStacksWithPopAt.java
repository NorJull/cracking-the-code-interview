package StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SetOfStacksWithPopAt<T> {

    class StackNode<T> {
        T data;
        int index;
        StackNode next;

        StackNode(T data) {
            this.data = data;
        }
    }

    private int currentStackCount;
    private int currentStackIndex;

    private static final int THRESHOLD = 2;

    private List<StackNode> stacks;

    public SetOfStacksWithPopAt() {
        this.currentStackCount = 0;
        this.currentStackIndex = 0;
        stacks = new ArrayList<>();
    }

    public void push(T value) {
        if (stacks.isEmpty()) {
            StackNode<T> top = new StackNode<>(value);
            top.index = 1;
            stacks.add(top);
            currentStackIndex = 0;
            return;
        }

        StackNode<T> top = stacks.get(currentStackIndex);
        StackNode<T> node = new StackNode<>(value);

        if (top.index < THRESHOLD) {
            node.index = top.index + 1;
            node.next = top;
            top = node;
            stacks.set(currentStackIndex, top);
        } else {
            node.index = 1;
            stacks.add(node);
            currentStackIndex++;
        }
    }

    public T pop() {
        if (stacks.isEmpty() || currentStackIndex < 0)
            throw new EmptyStackException();

        StackNode<T> top = stacks.get(currentStackIndex);

        if (top == null) {
            stacks.remove(currentStackIndex);
            currentStackIndex--;
            return pop();
        }

        T value = top.data;
        top = top.next;
        stacks.set(currentStackIndex, top);
        return value;
    }

    public T popAt(int index) {
        if (stacks.isEmpty())
            throw new EmptyStackException();

        if(index < 0 || index > stacks.size() - 1)
            throw new IndexOutOfBoundsException();


        StackNode<T> top = stacks.get(index);

        if (top == null) {
            stacks.remove(index);
            throw new RuntimeException("There is not stack at this index");
        }

        T value = top.data;
        top = top.next;
        stacks.set(index, top);
        return value;
    }


}

