package StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/*
3.3 Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
    Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
    Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks
    and should create a new stack once the previous one exceeds capacity. SetOfStacks. push() and SetOfStacks pop()
    should behave identically to a single stack (that is, pop() should return the same values as it would if there
    were just a single stack).

FOLLOW UP

Implement a function popAt(int index)which performs a pop operation on a specific sub-stack.
Hints:#64, #81
* */
public class SetOfStacks<T> {

    class StackNode<T> {
        T data;
        StackNode next;
        StackNode(T data) {
            this.data = data;
        }
    }
    private int currentStackCount;
    private int currentStackIndex;

    private static final int THRESHOLD = 2;

    private List<StackNode> stacks;

    public SetOfStacks() {
        this.currentStackCount = 0;
        this.currentStackIndex = 0;
        stacks = new ArrayList<>();
    }
    public void push(T value) {
        if(stacks.isEmpty()) {
            StackNode<T> top = new StackNode<>(value);
            stacks.add(top);
            currentStackCount = 1;
            currentStackIndex = 0;
            return;
        }
        if(currentStackCount < THRESHOLD) {
            StackNode<T> node = new StackNode<>(value);
            if(currentStackIndex == stacks.size()) {
                stacks.add(node);
            } else {
                StackNode<T> top = stacks.get(currentStackIndex);
                node.next = top;
                top = node;
                stacks.set(currentStackIndex, top);
            }
            currentStackCount++;
        } else {
            currentStackIndex++;
            currentStackCount = 0;
            push(value);
        }
    }

    public T pop() {

        if(stacks.isEmpty() || currentStackIndex < 0)
            throw new EmptyStackException();

        StackNode<T> top = stacks.get(currentStackIndex);

        if(top == null) {
            currentStackIndex--;
            currentStackCount = THRESHOLD;
            return pop();
        }

        T value = top.data;
        top = top.next;
        stacks.set(currentStackIndex, top);
        currentStackCount --;
        return value;
    }


}

