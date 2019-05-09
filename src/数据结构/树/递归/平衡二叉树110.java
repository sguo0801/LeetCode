package 数据结构.树;
//求最大深度与平衡二叉树都是判断深度,采用递归的方法,单纯求深度,递归到root==null,返回0,每一层更新深度+1.
//而判断平衡二叉树,要剪枝,也是递归到root==null,但是从下往回返值时有剪枝操作,如果下面左右子树深度差>1,则返回-1,作为非平衡的象征,一直返回到最上面,不需要再进行计算比较.
//如果平衡的话,桶样返回正常深度.
public class 平衡二叉树110 {
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
        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }
            return getDepth(root) != -1;  //不为-1,则说明平衡.即true.
        }

        private int getDepth(TreeNode root){
            if(root == null){
                return 0;
            }

            int left = getDepth(root.left);
            if(left == -1){
                return -1;
            }
            int right = getDepth(root.right);
            if(right == -1){
                return -1;
            }

            return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;

        }
    }
}
