package org.kaidzen.study.leetcode.june2020;

import org.kaidzen.study.leetcode.util.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;
    }

    public static void main(String[] args) {
//        4
//      /   \
//     2     7
//    / \   / \
//   1   3 6   9
        int[] arr = new int[]{4, 2, 7, 1, 3, 6, 9};
        InvertBinaryTree binaryTree = new InvertBinaryTree();
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(binaryTree.invertTree(root));
    }
}
