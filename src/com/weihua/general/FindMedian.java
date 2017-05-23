package com.weihua.general;

import java.util.PriorityQueue;

/*
 * given a stream of integer, find the median.
 * Maintain a max priority queue and a min priority queue(heap), the size of the two queues should be no larger than 1
 * define the median as (a + b) / 2 if even numbers
 * whenever there is a new integer, compare with current median, if larger than current median, insert into large queue;
 * otherwise insert into small queue.
 * after insertion, adjust the queue sizes to balance 
 */
public class FindMedian {
    PriorityQueue<Integer> largerMinQueue = new PriorityQueue<Integer>();
    PriorityQueue<Integer> smallerMaxQueue = new PriorityQueue<Integer>(10, new ReverseNaturalOrderComparator<Integer>());
    
    public void insert(Integer input) {
        if (input == null) {
            return;
        }
        
        Integer currentMedian = getMedian();
        if (currentMedian == null) {
            currentMedian = input;
        }
        if (input > currentMedian) {
            largerMinQueue.offer(input);
        } else {
            smallerMaxQueue.offer(input);
        }
        
        balanceHeap();
    }
    
    public void balanceHeap() {
        if (Math.abs(largerMinQueue.size() - smallerMaxQueue.size()) <= 1) {
            return;
        }
        
        if (largerMinQueue.size() > smallerMaxQueue.size()) {
            Integer intToChange = largerMinQueue.remove();
            smallerMaxQueue.offer(intToChange);
        }
    }
        
    private Integer getMedian() {
        if (largerMinQueue.size() == 0 && smallerMaxQueue.size() == 0) {
            return null;
        } 
        if (largerMinQueue.size() == smallerMaxQueue.size()) {
            return (largerMinQueue.peek() + smallerMaxQueue.peek()) / 2;
        } else if (largerMinQueue.size() > smallerMaxQueue.size()) {
            return largerMinQueue.peek();
        } else {
            return smallerMaxQueue.peek();
        }
    }
    
    public Integer getMedianForDisplay() {
        if (largerMinQueue.size() == smallerMaxQueue.size() && largerMinQueue.size() != 0) {
            return largerMinQueue.peek();
        } 
        
        return getMedian();
    }
    
    public static void main(String[] args) {
        FindMedian test = new FindMedian();
        
        int[] inputStream = new int[]{1, 10, 2, 9};
        for (int i = 0; i < inputStream.length; i++) {
            test.insert(inputStream[i]);
            System.out.println(test.getMedianForDisplay());
        }
    }
}
