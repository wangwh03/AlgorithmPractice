package com.weihua.general;

/*
 * check if two rectagular overlaps
 * basically check if they do not overlap. If directly check overlap, then gets complicated if one is inside the other
 */
public class RectagularOverlap {

    public static void main(String[] args) {
        RectagularOverlap test = new RectagularOverlap();
        Rectagular r1 = new Rectagular(new Node(1, 4), new Node(4, 1));
        Rectagular r2 = new Rectagular(new Node(3, 2), new Node(2, 3));

        System.out.println(test.isOverlapped(r1, r2));
    }
    
    private boolean isOverlapped(Rectagular r1, Rectagular r2) {
        if (r1.upperLeft.x > r2.lowerRight.x
                || r1.lowerRight.x < r2.upperLeft.x
                || r1.upperLeft.y < r2.lowerRight.y
                || r1.lowerRight.y > r2.upperLeft.y) {
            return false;
        }
        
        return true;
    }
    
    public static class Rectagular {
        private Node upperLeft;
        private Node lowerRight;

        public Rectagular(Node node1, Node node2) {
            this.upperLeft = node1;
            this.lowerRight = node2;
        }
        
        public void setUpperLeft(Node upperLeft) {
            this.upperLeft = upperLeft;
        }
        
        public Node getUpperLeft() {
            return upperLeft;
        }
        
        public void setLowerRight(Node lowerRight) {
            this.lowerRight = lowerRight;
        }
        
        public Node getLowerRight() {
            return lowerRight;
        }
    }
    
    public static class Node {
        private int x;
        private int y;
        
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return x;
        }
        
        public void setX(int x) {
            this.x = x;
        }
        
        public int getY() {
            return y;
        }
        
        public void setY(int y) {
            this.y = y;
        }
    }
}
