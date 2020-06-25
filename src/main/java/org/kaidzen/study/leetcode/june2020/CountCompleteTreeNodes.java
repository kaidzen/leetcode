package org.kaidzen.study.leetcode.june2020;

import org.kaidzen.study.leetcode.util.TreeNode;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        TreeNode left = root, right = root;
        int h_l = 0, h_r = 0;
        while(left != null){
            h_l++;
            left = left.left;
        }
        while(right != null){
            h_r++;
            right = right.right;
        }
        if(h_l == h_r) return (1<<h_l) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        CountCompleteTreeNodes trees = new CountCompleteTreeNodes();
//        Input:
//          1
//         / \
//        2   3
//        / \  /
//        4  5 6
//        Output: 6
//        trees.countNodes(new int[]{1,2,3,4,5,6});
    }
}
