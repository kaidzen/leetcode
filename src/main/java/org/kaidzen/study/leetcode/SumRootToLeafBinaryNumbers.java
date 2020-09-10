package org.kaidzen.study.leetcode;

import org.kaidzen.study.leetcode.util.TreeNode;

public class SumRootToLeafBinaryNumbers {

    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    private int sumRootToLeaf(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        sum = (sum << 1) + root.val;
        if (root.left == null && root.right == null){
            return sum;
        }
        return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
    }

    public static void main(String[] args) {
        SumRootToLeafBinaryNumbers sumBinaries = new SumRootToLeafBinaryNumbers();
//        Input: [1,0,1,0,1,0,1]
//        Output: 22
//        Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
        int result = sumBinaries.sumRootToLeaf(
                new TreeNode(1,
                        new TreeNode(0, new TreeNode(0, null, null), new TreeNode(1, null, null)),
                        new TreeNode(1,
                                new TreeNode(0, null, null), new TreeNode(1, null, null)))
        );
        System.out.println(result);
    }
}
