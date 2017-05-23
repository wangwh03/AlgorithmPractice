package com.weihua.general;

import java.util.List;

public class PrintUtils {

    public static <T> void print(List<T> input) {
        for (T t : input) {
            System.out.println(t);
        }
    }
    
    public static <T> void print(T[] input) {
        for (T t : input) {
            System.out.println(t);
        }
    }
}
