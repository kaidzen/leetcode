package org.kaidzen.study.leetcode.y2023_2024.b_trees;

import org.kaidzen.study.leetcode.util.TreeNode;

import java.util.*;

public class PreOrder {

    private final List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        PreOrder pre = new PreOrder();
        //[1,null,2,3]
        TreeNode node = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        //[3,2,1]
        TreeNode node1 = new TreeNode(3, new TreeNode(2), new TreeNode(1));

        System.out.println((pre.traversal1(node)));
        System.out.println((pre.traversal1(node1)));

        System.out.println((pre.traversal2(node)));
        System.out.println((pre.traversal2(node1)));

        System.out.println((pre.traversal3(node)));
        System.out.println((pre.traversal3(node1)));
    }

    public List<Integer> traversal1(TreeNode root) {
        answer.clear();
        dfs(root);
        return answer;
    }

    private void dfs(TreeNode node) {
        if (Objects.nonNull(node)) {
            this.answer.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }

    public List<Integer> traversal2(TreeNode root) {
        final List<Integer> answer = new ArrayList<>();
        final Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curNode = stack.peek();
            stack.pop();
            if (curNode != null) {
                answer.add(curNode.val);
                if (Objects.nonNull(curNode.right)) stack.push(curNode.right);
                if (Objects.nonNull(curNode.left)) stack.push(curNode.left);
            }
        }
        return answer;
    }

    public List<Integer> traversal3(TreeNode root) {
        final List<Integer> answer = new ArrayList<>();
        TreeNode current = root, last;

        while (current != null) {
            if(current.left == null){
                answer.add(current.val);
                current = current.right;
            } else {
                last = current.left;
                last.right = null;
                current = current.left;
            }
        }
        return answer;
    }
}
