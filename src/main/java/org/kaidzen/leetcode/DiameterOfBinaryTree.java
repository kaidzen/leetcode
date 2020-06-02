package org.kaidzen.leetcode;

import javafx.util.Pair;

import javax.swing.text.MutableAttributeSet;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int diameter = maxDepth(root.left) + maxDepth(root.right);
        return Math.max(diameter, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    private int maxDepth(TreeNode node) {
        if (node == null){
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }

    private Pair<Integer, Integer> dfs(TreeNode root){
        if (root == null){
            return new Pair<>(0, 0);
        }
        Pair<Integer, Integer> left = dfs(root.left);
        Pair<Integer, Integer> right = dfs(root.right);
        int diameter = Math.max(Math.max(left.getKey(), right.getValue()), left.getValue() + right.getValue());
        return new Pair<>(diameter, Math.max(left.getValue(), right.getValue()) + 1);
    }

    public static void main(String[] args) {

    }
}
