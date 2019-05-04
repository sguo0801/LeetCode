package 数据结构.树;
//就是两边最大深度和,通过递归求最大深度的过程找到最大的max.平衡就是在求最大深度(要这个过程)的同时利用深度差判断.
public class 二叉树两点最大距离543 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int max = 0; //最长的距离就是左右子树深度最大值的和
        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);
            return max;
        }

        private int depth(TreeNode root){
            if(root == null){
                return 0;
            }
            int left = depth(root.left);
            int right = depth(root.right);

            max = Math.max(max, left + right);
            return Math.max(left, right) + 1;
        }
    }
}
