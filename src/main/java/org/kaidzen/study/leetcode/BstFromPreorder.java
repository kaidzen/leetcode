package org.kaidzen.study.leetcode;

public class BstFromPreorder {

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) { return null;}
        TreeNode root = null;
        for(int val : preorder)
            root = helper(root, val);

        return root;
    }

    private TreeNode helper(TreeNode node, int val) {
        if(node == null) return new TreeNode(val);
        if(val < node.val) {
            node.left = helper(node.left, val);
        } else {
            node.right = helper(node.right, val);
        }
        return node;
    }

    public static void main(String[] args) {
        int[] input1 = new int[] {8,5,1,7,10,12};
        String output = "8,5,10,1,7,null,12";

        BstFromPreorder bstCreator = new BstFromPreorder();

        System.out.println(bstCreator.bstFromPreorder(input1));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", l=" + left +
                    ", r=" + right +
                    '}';
        }
    }
}
