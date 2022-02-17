package org.kaidzen.study.leetcode.june2020;

import org.kaidzen.study.leetcode.util.TreeNode;

public class SumRootToLeafNumbers {

    private int answer = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return answer;
    }

    private void dfs(TreeNode root, int value) {
        if (root == null) {
            return;
        }
        //As for decimals, we will increase order of number by 10
        int shiftedValue = value * 10;
        shiftedValue += root.val;
        if (root.left == null && root.right == null) {
            //For each leaf we have answer, so summarize it.
            answer += shiftedValue;
            return;
        }
        dfs(root.left, shiftedValue);
        dfs(root.right, shiftedValue);
    }

    public static void main(String[] args) {
//        Input: [1,2,3]
//         1
//        / \
//       2   3
//        Output: 25
//        Explanation:
//        The root-to-leaf path 1->2 represents the number 12.
//        The root-to-leaf path 1->3 represents the number 13.
//        Therefore, sum = 12 + 13 = 25.
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3, null, null));
        SumRootToLeafNumbers fromRootToLeafs = new SumRootToLeafNumbers();
        System.out.println(fromRootToLeafs.sumNumbers(root));
    }
}
