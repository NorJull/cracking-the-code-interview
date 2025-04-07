package StacksAndQueues;

/*
Three in One: Describe how you could use a single array to implement three stacks.
Hints: #2, #12, #38, #58
* */
public class ThreeInOne {

    public static void main(String[] args) {
        System.out.println(3%3);
    }
    private int[] array;

    private StackInfo[] informations;
    public ThreeInOne(int numberOfStacks, int size) {
        array = new int[size * numberOfStacks];

        informations = new StackInfo[numberOfStacks];
        int startPoint = 0;
        for (int i = 0; i < numberOfStacks; i++) {
            //(int startPoint, int capacity, int last, boolean hasSpace
            StackInfo info = new StackInfo(startPoint, size, -1, true);
            informations[i] = info;
            startPoint = startPoint + size;

        }
    }

    /*
    * parameters:
    * data: value to push
    * stackNumber: stack where the value would be inserted. starting from stack number 1 up to numberOfStacks
    * */
    public void push(int data, int stackNumber) {
        StackInfo info = informations[stackNumber];
        if(info.hasSpace) {
            int nextIndex = calculateWhereToInsert( info.last);
            array[nextIndex] = data;
            info.last = nextIndex;
            info.hasSpace = calculateHasSpace(info.startPoint, info.last, info.capacity);
        } else if(checkAvailabilityOnOtherStacks(stackNumber)) {
            shift((stackNumber + 1) % informations.length);
            info.capacity++;
            int nextIndex = calculateWhereToInsert( info.last);
            array[nextIndex] = data;
            info.last = nextIndex;
            info.hasSpace = calculateHasSpace(info.startPoint, info.last, info.capacity);
        }
    }

    /*
    shift next stack by one.
    * */
    private void shift(int stackNumber) {
        StackInfo info = informations[stackNumber];

        if(!info.hasSpace) {
            shift((stackNumber + 1) % informations.length);
            info.capacity++;
        }

        // Move each element to the right by one
        int index= info.lastCapacityindex();
        while (info.isWithinStackCapacity(index)) {
            array[index] = array[previousIndex(index)];
            index= previousIndex(index);
        }

        array[info.startPoint] = 0;
        info.startPoint = nextIndex(info.startPoint);
        info.capacity--;
    }

    private int previousIndex(int index) {
        if(index == 0)
            return array.length - 1;

        return index - 1;
    }

    private int nextIndex(int index) {
        return (index +1) % array.length;
    }

    /*
    * Check whether there are a available spot in any of the others stacks.
    * */
    private boolean checkAvailabilityOnOtherStacks(int stackNumber) {
        for (int i = 0; i < informations.length; i++) {
            if(i == stackNumber)
                continue;
            if(informations[i].hasSpace)
                return true;
        }
        return false;
    }

    /*
    * Calculate whether a stack has space to push new elements or not
    * */
    private boolean calculateHasSpace(int startPoint, int last, int capacity) {
        if((startPoint + capacity - 1) <= (array.length - 1)) {
            return last < startPoint + capacity - 1;
        } else {
            int rest = ( startPoint + capacity - 1) - (array.length - 1);
            return last != (rest-1);
        }
    }

    /*
    Calculate index where a value being pushed should be inserted.
    * */
    private int calculateWhereToInsert(int last) {
        if( last == array.length - 1)
            return 0;
        else
            return last + 1;
    }

    public int pop(int stack) {
    return 0;
    }

    public int peek(int stack) {
       return 0;
    }

    public boolean isEmpty(String stack) {

        return false;
    }

    class StackInfo {
        int startPoint;

        int capacity;

        int last;

        boolean hasSpace;

        public StackInfo(int startPoint, int capacity, int last, boolean hasSpace){
            this.startPoint = startPoint;
            this.capacity = capacity;
            this.last = last;
            this.hasSpace = hasSpace;
        }

        public int lastCapacityindex() {
            return 0;
        }

        public boolean isWithinStackCapacity(int index) {
            return true;
        }
    }
}
