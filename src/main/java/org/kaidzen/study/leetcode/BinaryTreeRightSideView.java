package org.kaidzen.study.leetcode;

import org.kaidzen.study.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeRightSideView {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        collectAllRight(root);

        return result;
    }

    private void collectAllRight(TreeNode root){
        result.add(root.val);
        TreeNode right = root.right;
        if (right != null){
//            checkNode(right.val);
            collectAllRight(right);
        }
    }

    private void checkNode(int val) {
        result.add(val);
    }

    public static void main(String[] args) {

    }
}
