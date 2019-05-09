package 数据结构.树;

public class 对称二叉树101 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    //找一个help方法,进行判断,递归向下查找非对称结点.
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return root == null || isSymmetric(root.left, root.right);  //返回默认true.
        }

        private boolean isSymmetric(TreeNode left, TreeNode right){
            if(left == null && right == null){
                return true;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}
