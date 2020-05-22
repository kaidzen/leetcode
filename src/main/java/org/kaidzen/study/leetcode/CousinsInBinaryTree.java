package org.kaidzen.study.leetcode;

import org.kaidzen.study.leetcode.util.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CousinsInBinaryTree {
    private int x;
    private int y;
    private final AtomicInteger dX = new AtomicInteger();
    private final AtomicInteger dY = new AtomicInteger();
    private final AtomicInteger pX = new AtomicInteger(-1);
    private final AtomicInteger pY = new AtomicInteger(-1);

    public boolean isCousins(org.kaidzen.study.leetcode.util.TreeNode root, int x, int y) {
        if(root == null || root.val == x || root.val == y){
            return false;
        }
        this.x = x;
        this.y = y;
        dfs(root, 0);
        return (dX.get() == dY.get()) && (pX.get() != pY.get());
    }

    private void dfs(org.kaidzen.study.leetcode.util.TreeNode root, int depth){
        if (root == null) { return; }
        if (root.left != null){
            if (root.left.val == this.x) {
                pX.set(root.val);
                dX.set(depth + 1);
            } else if (root.left.val == this.y){
                pY.set(root.val);
                dY.set(depth + 1);
            }
        }
        if (root.right != null){
            if (root.right.val == this.x) {
                pX.set(root.val);
                dX.set(depth + 1);
            } else if (root.right.val == this.y){
                pY.set(root.val);
                dY.set(depth + 1);
            }
        }
        if ((dX.get() != -1) && (dY.get() != -1)) { return; }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }

    private org.kaidzen.study.leetcode.util.TreeNode xParent = null;
    private org.kaidzen.study.leetcode.util.TreeNode yParent = null;
    private int xDepth = -1;
    private int yDepth = -2;

    public boolean isCousins2(org.kaidzen.study.leetcode.util.TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        return xDepth == yDepth && xParent != yParent;
    }
    private void dfs(org.kaidzen.study.leetcode.util.TreeNode root, org.kaidzen.study.leetcode.util.TreeNode parent, int x, int y, int depth) {
        if (root == null) return;
        if (x == root.val) {
            xParent = parent;
            xDepth = depth;
        } else if (y == root.val) {
            yParent = parent;
            yDepth = depth;
        } else {
            dfs(root.left, root, x, y, depth + 1);
            dfs(root.right, root, x, y, depth + 1);
        }
    }

    public static void main(String[] args) {
//        Input: root = [1,2,3,4], x = 4, y = 3
//        Output: false
        int[] arr1 = new int[]{1,2,3,4};
        CousinsInBinaryTree cousins1 = new CousinsInBinaryTree();
        org.kaidzen.study.leetcode.util.TreeNode root1 = new org.kaidzen.study.leetcode.util.TreeNode(arr1[0], new org.kaidzen.study.leetcode.util.TreeNode(arr1[1], new org.kaidzen.study.leetcode.util.TreeNode(arr1[3]), null),
                new org.kaidzen.study.leetcode.util.TreeNode(arr1[2], null, null));
        System.out.println(cousins1.isCousins(root1, 4, 3));
//        [1,2,3,null,4,null,5], x=5, y=4
//        Output: false
        CousinsInBinaryTree cousins2 = new CousinsInBinaryTree();
        List<Integer> arr2 = Arrays.asList(1,2,3,null,4,null,5);
        org.kaidzen.study.leetcode.util.TreeNode root2 = new org.kaidzen.study.leetcode.util.TreeNode(arr2.get(0), new org.kaidzen.study.leetcode.util.TreeNode(arr2.get(1), null, new org.kaidzen.study.leetcode.util.TreeNode(arr2.get(4))),
                new org.kaidzen.study.leetcode.util.TreeNode(arr2.get(2), null, new org.kaidzen.study.leetcode.util.TreeNode(arr2.get(6))));
        System.out.println(cousins2.isCousins2(root2, 5, 4));
    }

    private static TreeNode createTree(int[] array) {
        return null;
    }
}
