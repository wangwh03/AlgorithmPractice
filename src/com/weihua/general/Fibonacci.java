package com.weihua.general;

import java.util.HashMap;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci test = new Fibonacci();
        System.out.println(test.getFibonacci(0));
        System.out.println(test.getFibonacci(1));
        System.out.println(test.getFibonacci(2));
        System.out.println(test.getFibonacci(3));
    }

    public int getFibonacci(int n) {
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        return getFibonacci(n, cache);
    }

    private int getFibonacci(int n, HashMap<Integer, Integer> cache) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int fibonacci = getFibonacci(n-1, cache) + getFibonacci(n-2, cache);
        cache.put(n, fibonacci);
        return fibonacci;
    }
}
