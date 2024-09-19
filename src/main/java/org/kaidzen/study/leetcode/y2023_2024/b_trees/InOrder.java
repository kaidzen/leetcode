package org.kaidzen.study.leetcode.y2023_2024.b_trees;

import org.kaidzen.study.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrder {

    public static void main(String[] args) {
        InOrder inOrder = new InOrder();
        //[1,null,2,3]
        TreeNode node = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        //[3,2,1]
        TreeNode node1 = new TreeNode(3, new TreeNode(2), new TreeNode(1));
        System.out.println(inOrder.traversal1(node));
        System.out.println(inOrder.traversal1(node1));
    }

    public List<Integer> traversal1(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root != null){
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }

    public List<Integer> traversal2(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        final Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
