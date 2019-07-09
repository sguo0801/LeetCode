package 数据结构.树.递归;
//思路:看当前的左子节点是否为叶子节点,如果是,则直接返回当前左叶子树val与右节点递归值的和;否则如果当前左子树不是叶子.那么返回左节点和右节点的递归值之和.
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
