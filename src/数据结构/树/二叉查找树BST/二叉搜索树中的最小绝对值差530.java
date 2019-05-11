package 数据结构.树.二叉查找树BST;

public class 二叉搜索树中的最小绝对值差530 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    //利用二叉查找树的中序遍历为有序的性质，计算中序遍历中临近的两个节点之差的绝对值，取最小值。
    class Solution {
        private TreeNode preNode = null; //作为前一个节点
        private int min = Integer.MAX_VALUE; //0x7fffffff;  先找到最大值,其+1为Integer.MIN_VALUE,即0x80000000;
        public int getMinimumDifference(TreeNode root) {
            inOrder(root);  //这边min是在递归中不断变化的,所以不能作为形参放进函数中,否则最后返回的还是初始值.
            return min;
        }

        private void inOrder(TreeNode root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            if(preNode != null){  //先判断前一个节点是否为null
                min = Math.min(min, root.val - preNode.val);  //这边是当前节点-前一个节点的值.题中说明都为非负.
            }
            preNode = root;  //第一次是作为根节点进行赋值.
            inOrder(root.right);

        }
    }
}
