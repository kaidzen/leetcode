package org.kaidzen.study.leetcode.y2023_2024.b_trees;

import org.kaidzen.study.leetcode.util.TreeNode;

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree() {
    }

    public void insertNode(int data) {
        this.root = insertHelper(root, data);
    }

    public void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            printInOrder(root.left);
            System.out.print(root.val + " -> ");
            printInOrder(root.right);
        }
    }

    private TreeNode insertHelper(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        if (data < root.val) {
            root.left = insertHelper(root.left, data);
        }
        if (data > root.val) {
            root.right = insertHelper(root.right, data);
        }
        return root;
    }

    public TreeNode getRoot() {
        return this.root;
    }
}
