package 数据结构.树.递归;

public class 打家劫舍二叉树337 {
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
        //递归,递归思想（不要深入递归函数体，只需知道递归函数的功能，以及找到跳出递归的边界条件）
        //思路：
        //能盗取的最高金额为 抢劫该节点+抢劫该节点的左孩子的左右子树+抢劫该节点的右孩子的左右子树
        //与 抢劫该节点的左子树+抢劫该节点的右子树的和  的最大值
        //执行用时 1005ms  原因是出现了很多重复的计算，可使用动态规划解决
//        public int rob(TreeNode root) {
//            if(root == null){
//                return 0;
//            }
//
//            int v1 = root.val;  //初始值为根节点的值
//            if(root.left != null){
//                v1 += rob(root.left.left) + rob(root.left.right);
//            }
//            if(root.right != null){
//                v1 += rob(root.right.left) + rob(root.right.right);
//            }
//            int v2 = rob(root.left) + rob(root.right);
//            return Math.max(v1, v2);
//        }
        //动归
        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         *     int val;
         *     TreeNode left;
         *     TreeNode right;
         *     TreeNode(int x) { val = x; }
         * }
         */
        //思路：
        //定义一个数组res,长度为2,res[0]表示不抢该节点可获得最大值,res[1]表示抢劫该节点可获得最大值
        //方法helper(r)意为：在以r为根节点的树中,返回抢劫根节点与不抢劫根节点可获得的最大值
            public int rob(TreeNode root) {
                int[] res = dps(root);
                return Math.max(res[0], res[1]);
            }

            private int[] dps(TreeNode root){
                if(root == null){//边界条件，r为null时，跳出
                    return new int[2];
                }
                int[] left = dps(root.left);//对于以r.left为根的树，计算抢劫根节点(r.left)与不抢劫根节点可获得最大金额. left[0]则为不抢r.left可获得的最大金额,left[1]则为抢劫r.left可获得的最大金额  以下right[] 分析同理
                int[] right = dps(root.right);
                int[] temp = new int[2];
                temp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);//计算不抢劫当前根节点可获得的最大金额(那么其左右子树可以随便抢)
                temp[1] = root.val + left[0] + right[0];//计算若抢劫根节点可获得的最大金额(此时,其左右子树的根节点不能被抢)
                return temp;
            }

    }
}
