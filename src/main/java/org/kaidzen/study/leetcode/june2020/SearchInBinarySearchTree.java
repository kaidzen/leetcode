package org.kaidzen.study.leetcode.june2020;

import org.kaidzen.study.leetcode.util.TreeNode;

public class SearchInBinarySearchTree {

    //Iterative approach
    public TreeNode searchBST2(TreeNode root, int val) {
        TreeNode current = root;
        while (current != null){
            if (current.val == val) { return current;}
            if (current.val > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    //Recursive approach
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) { return  root;}
        if (root.val > val){
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {

    }
}
