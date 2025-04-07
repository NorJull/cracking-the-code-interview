package StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/*
3.2 Stack Min: How would you design a stack which, in addition to push and pop, has a function min which returns
the minimum element? Push, pop and min should all operate in 0(1) time.
Hints:#27, #59, #78

If the stack is made using Nodes we could save the minimum value in each Node.

* */
public class StackMin {
    List<Integer> values  = new ArrayList<>();
    List<Integer> minIndex = new ArrayList<>();

    public void push(Integer value) {
        if(values.isEmpty()) {
            //First element would be the minimum at the beginning
            minIndex.add(0);
            values.add(value);
            return;
        }
        values.add(value);
        int lastIndexOfMin = minIndex.size() - 1;
        if(values.get(minIndex.get(lastIndexOfMin)) > value) {
            minIndex.add(values.size() - 1);
        }
    }

    public Integer pop() {
        if(values.isEmpty())
            throw new EmptyStackException();

        int lastIndexOfMin = minIndex.size() - 1;
        int lastIndexOfValues = values.size() - 1;

        if(lastIndexOfValues == minIndex.get(lastIndexOfMin)) {
            minIndex.remove(lastIndexOfMin);
        }

        Integer element = values.get(lastIndexOfValues);
        values.remove(lastIndexOfValues);
        return element;
    }

    public Integer min() {
        if(values.isEmpty())
            throw new EmptyStackException();

        int lastIndexOfMin = minIndex.size() - 1;

        return values.get(minIndex.get(lastIndexOfMin));
    }
}
