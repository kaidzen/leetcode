package org.kaidzen.study.leetcode;

import org.kaidzen.study.leetcode.util.TreeNode;

public class FindCorrespondingNodeOfBinaryTreeInCloneOfThatTree {

    private TreeNode target;
    private TreeNode result;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        inOrder(original, cloned);
        return this.result;
    }

    private void inOrder(TreeNode origin, TreeNode clone) {
        if (origin != null) {
            //Traversal in order -> (Left, Root, Right)
            inOrder(origin.left, clone.left);
            if (origin == target) {
                this.result = clone;
            }
            //Or
            inOrder(origin.right, clone.right);
        }
    }

    public static void main(String[] args) {

    }
}
