package com.weihua.tree;

/*
 * check if one tree is the subtree of another
 */
public class SubTreeJudger {

    public static void main(String[] args) {
        SubTreeJudger test = new SubTreeJudger();
        Node tree1 = TreeUtils.createTree();
        Node tree2 = TreeUtils.createSubTree();
        System.out.println(test.isSubTree(tree1, tree2));
        
        Node tree3 = TreeUtils.createAnotherTree();
        System.out.println(test.isSubTree(tree1, tree3));
        
        System.out.println(test.isSubTree(tree1, null));
        System.out.println(test.isSubTree(null, null));
        System.out.println(test.isSubTree(null, tree2));
        System.out.println(test.isSubTree(tree2, tree3));
    }
    
    
    public boolean isSubTree(Node root1, Node root2) {
        if (root2 == null) {
            return true;
        } else if (root1 == null) {
            return false;
        }

        if(isTreeIdentical(root1, root2)) {
            return true;
        }

        return isSubTree(root1.getLeft(), root2) || isSubTree(root1.getRight(), root2);
    }

    private boolean isTreeIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.getValue() != root2.getValue()) {
            return false;
        }

        return isTreeIdentical(root1.getLeft(), root2.getLeft())
                && isTreeIdentical(root1.getRight(), root2.getRight());
    }
}
