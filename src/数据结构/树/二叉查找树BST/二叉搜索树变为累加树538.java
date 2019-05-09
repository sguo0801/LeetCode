package 数据结构.树.二叉查找树BST;

public class 二叉搜索树变为累加树538 {
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
        private int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            //从最大的值开始改变val,即右,根,左;
            inOrderRev(root);
            return root;
        }

        private void inOrderRev(TreeNode root){
            if(root == null){
                return;
            }

            inOrderRev(root.right);  //一直递归到最右下
            sum += root.val;  //此时作为根进行改val
            root.val = sum;
            inOrderRev(root.left); //左
        }
    }
}
