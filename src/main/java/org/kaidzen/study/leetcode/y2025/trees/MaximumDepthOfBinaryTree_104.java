package org.kaidzen.study.leetcode.y2025.trees;

import org.kaidzen.study.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down
 * to the farthest leaf node.
 *
 * Example 1:
 *      (3)
 *     /    \
 *  (9)     (20)
 *          /   \
 *      (15)    (7)
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 *  Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class MaximumDepthOfBinaryTree_104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<Pair> stack = new ArrayDeque<>();
        stack.addFirst(new Pair(root, 1));
        int ans = 0;
        while (!stack.isEmpty()) {
            Pair pair = stack.removeFirst();
            int depth = pair.depth;
            ans = Math.max(depth, ans);

            final TreeNode node = pair.node;
            if (node.left != null) {
                stack.addFirst(new Pair(node.left, depth+1));
            }
            if (node.right != null) {
                stack.addFirst(new Pair(node.right, depth+1));
            }
        }
        return ans;
    }

}
 class Pair {
    TreeNode node;
    int depth;

     public Pair(TreeNode node, int depth) {
         this.node = node;
         this.depth = depth;
     }
 }