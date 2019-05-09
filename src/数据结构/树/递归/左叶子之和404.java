package 数据结构.树.递归;

public class 左叶子之和404 {
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
        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null){
                return 0;
            }
            if(isFeed(root.left)){  // 如果当前的左儿子是叶子节点.
                return root.left.val + sumOfLeftLeaves(root.right);  //左儿子是否满足,都要递归+右儿子
            }
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }

        private boolean isFeed(TreeNode root){
            if(root == null){
                return false;
            }
            if(root.left == null && root.right == null){
                return true;
            }
            return false;
        }
    }
}
