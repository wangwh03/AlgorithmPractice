package com.weihua.general;

/*
 * storing this in an array is a disaster since each time you add/remove an element from array,
 * you need to create a new array.
 * See InsertIntervalList instead
 */
public class InsertIntervalArray {

    public static void main(String[] args) {
        InsertIntervalArray test = new InsertIntervalArray();
        Interval[]input = new Interval[]{new Interval(0, 2), 
                new Interval(10, 15)};
        Interval newInterval = new Interval(7, 8);
        Interval[] newInput = test.insertAndOrder(input, newInterval);
        test.print(newInput);
    }

    public Interval[] insertAndOrder(Interval[] input, Interval newInterval) {
        // assume input is sorted by left
        int i = input.length - 1;
        Interval[] newInput = new Interval[input.length + 1];
        while (i >= 0 && input[i].getLeft() >= newInterval.getLeft()) {
            newInput[i+1] = input[i];
            i--;
        }

        int newIndex = i+1;
        newInput[newIndex] =  newInterval;

        while (i >= 0) {
            newInput[i] = input[i];
            i--;
        }

        i = newIndex - 1;
        while(i+1 < newInput.length && isOverlap(newInput[i], newInput[i+1])) {
            newInput = merge(newInput, i+1, i);
        }

        return newInput;
    }

    private boolean isOverlap(Interval i1, Interval i2) {
        return isBetween(i1.getLeft(), i2) || isBetween(i1.getRight(), i2) 
                || isBetween(i2.getLeft(), i1) || isBetween(i2.getRight(), i1);
    }

    private boolean isBetween(int index, Interval interval) {
        if (index <= interval.getRight() && index >= interval.getLeft()) {
            return true;
        }

        return false;
    }

    private Interval[] merge(Interval[] input, int right, int left) {
        // assuming newInterval is inserted left side of interval index
        Interval intervalToMerge = input[right];
        Interval newInterval = input[left];
        if (newInterval.getLeft() <= intervalToMerge.getLeft() && newInterval.getRight() >= intervalToMerge.getRight()) {
            // remove right interval
            input = remove(input, right);
        } else 	if (newInterval.getLeft() == intervalToMerge.getLeft() && newInterval.getRight() <= intervalToMerge.getRight()) {
            input = remove(input, left);
        } else if (newInterval.getLeft() < intervalToMerge.getLeft() && newInterval.getRight() <= intervalToMerge.getRight()) {
            Interval interval = new Interval(newInterval.getLeft(), intervalToMerge.getRight());
            input = remove(input, left);
            input = remove(input, right-1);
            input = insert(input, left, interval);
        }
        return input;
    }

    private Interval[] insert(Interval[] input, int indexToInsert, Interval interval) {
        int i = input.length - 1;
        Interval[] newInput = new Interval[input.length + 1];
        while (i >= indexToInsert) {
            newInput[i+1] = input[i];
            i--;
        }

        newInput[indexToInsert] = interval;
        i--;
        while (i >= 0) {
            newInput[i] = input[i];
            i--;
        }
        return newInput;
    }

    private Interval[] remove(Interval[] input, int indexToRemove) {
        int i = 0;
        Interval[] newInput = new Interval[input.length - 1];
        while (i < indexToRemove) {
            newInput[i] = input[i];
            i++;
        }
        while (i+1 < input.length) {
            newInput[i] = input[i+1];
            i++;
        }

        return newInput;
    }

    private void print(Interval[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
}
