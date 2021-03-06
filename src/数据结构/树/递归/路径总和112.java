package 数据结构.树.递归;
//思路就是递归向下传更新的num值.当恰好为叶子节点且num与当前节点值相同则true
public class 路径总和112 {
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
        //每经过一个节点sum更新,递归是到没有子节点且根的值为更新出来的sum即返回true;
        public boolean hasPathSum(TreeNode root, int sum) {
            if(root == null){
                return false;
            }

            if(root.left == null && root.right == null && root.val == sum){
                return true;
            }

            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);  //注意这里是||.有一边实现即可.
        }
    }
}
