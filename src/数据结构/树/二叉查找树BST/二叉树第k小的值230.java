package 数据结构.树.二叉查找树BST;

public class 二叉树第k小的值230 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    //在二叉查找树中,中序遍历则是按照元素值的从小到大排列的,所以对中序遍历进行改动.
    class Solution {
        int res;  //最终结果
        int count;  //计数

        public int kthSmallest(TreeNode root, int k) {
            //中序遍历解法

            order(root, k);
            return res;
        }

        private void order(TreeNode root, int k) {
            if (root == null) {
                return; //最开始找到最小值,到这边截止.
            }

            order(root.left, k);  //找最下角的节点,如果到头了,说明遇到最小值,开始计数.此时的root为最小的节点,root.left为null,所以这里返回,+1是加上root这个节点
            count++;  //加完要判断.
            //中序遍历改动的核心就是在这里,进行结果判断和赋值.
            if (count == k) {
                res = root.val;  //root此时是第k个节点,找到结果赋值给res.
            }

            //中序遍历,要看最小值的root的右儿子啦.因为会比root大一点,继续找最小.这里结束递归递归返回到上一层.
            order(root.right, k);

        }
    }
}
