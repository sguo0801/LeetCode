package 数据结构.树;

public class 路径总和可以不从头开始437 {
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
        public int pathSum(TreeNode root, int sum) {
            //三种初始情况,一种是计算当前节点值,一种是忽略当前从左子开始,一种是忽略当前从右子开始,(后两种没有开始计算)
            //只要开始计算啦,就要连续,所以后面的方法都得是加和方法sumStart()进行递归;
            if(root == null){
                return 0;
            }
            int res = 0;
            res = sumStart(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
            return res;
        }

        private int sumStart(TreeNode root, int sum){
            if(root == null){
                return 0;
            }
            int res = 0;  //每一次只要开始计算后,都是各层计算后面的总数,再加回上一层的res.最后从最上面一层返回.
            if(root.val == sum){
                res++;  //如果当层就满足,那直接加一种情况
            }
            res += sumStart(root.left, sum - root.val) + sumStart(root.right, sum - root.val);  //如果当层不满足就继续向下计算递归,即便满足啦,后面也可能有0,结果或许更多.
            return res;
        }
    }
}
