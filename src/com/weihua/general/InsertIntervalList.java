package com.weihua.general;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * 
 */
public class InsertIntervalList {

    public static void main(String[] args) {
        InsertIntervalList test = new InsertIntervalList();
        List<Interval> input = new LinkedList<Interval>();
        input.add(new Interval(0, 1));
        input.add(new Interval(2, 7));
        input.add(new Interval(10, 11));
        Interval intervalToInsert = new Interval(7, 8);
        PrintUtils.print(test.insert(input, intervalToInsert));
    }
    
    public List<Interval> insert(List<Interval> input, Interval intervalToInsert) {
        Iterator<Interval> iterator = input.iterator();
        List<Interval> newInput = new LinkedList<Interval>();
        while (iterator.hasNext()) {
            Interval interval = iterator.next();
            if (interval.getLeft() > intervalToInsert.getRight()) {
                newInput.add(intervalToInsert);
                newInput.add(interval);
                while (iterator.hasNext()) {
                    newInput.add(iterator.next());
                }
                return newInput;
            } else if (interval.getRight() < intervalToInsert.getLeft()){
                newInput.add(interval);
            } else {
                intervalToInsert = new Interval(Math.min(interval.getLeft(), intervalToInsert.getLeft()), 
                        Math.max(interval.getRight(), intervalToInsert.getRight()));
            }
        }
        
        newInput.add(intervalToInsert);
        return newInput;
    }
}
