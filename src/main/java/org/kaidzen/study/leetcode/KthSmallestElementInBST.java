package org.kaidzen.study.leetcode;

import org.kaidzen.study.leetcode.util.TreeNode;

public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        int[] nums = new int[2];
        inOrder(root, nums, k);

        return nums[0];
    }

    private void inOrder(TreeNode root, int[] nums, int k) {
        if (root == null){
            return;
        }
        inOrder(root.left, nums, k);
        if (++nums[0] == k) {
            nums[1] = root.val;
            return;
        };
        inOrder(root.right, nums, k);
    }

    public static void main(String[] args) {
        KthSmallestElementInBST smallest = new KthSmallestElementInBST();
//        Input: root = [3,1,4,null,2], k = 1
//            3
//           / \
//          1   4
//           \
//            2
//        Output: 1
    }
}