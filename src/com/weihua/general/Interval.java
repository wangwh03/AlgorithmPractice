package com.weihua.general;

public class Interval {
    private int left;
    private int right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[")
                .append(left)
                .append(", ")
                .append(right)
                .append("]")
                .toString();
    }
}