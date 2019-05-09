package 数据结构.树;
//????res=Math.max不是很懂,默认当前节点值与两边路径相同吗?
public class 最长同值路径687 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
//对于任意一个节点, 如果最长同值路径包含该节点, 那么只可能是两种情况:
    //  1. 其左右子树中加上该节点后所构成的同值路径中较长的那个继续向父节点回溯构成最长同值路径
//也就是从下到上一条线.
    //2. 左右子树加上该节点都在最长同值路径中, 构成了最终的最长同值路径
//相当于从左到右.
    // 需要注意因为要求同值, 所以在判断左右子树能构成的同值路径时要加入当前节点的值作为判断依据
    class Solution {
        int res = 0;  //类中方法要用,作为变量不能用final,不像方向矩阵不变可以用final.
        public int longestUnivaluePath(TreeNode root) {
            if(root == null){
                return 0;
            }
            dps(root, root.val);  //回溯的val作为从下到上的标准
            return res;
        }

        private int dps(TreeNode node, int val){  //node是当前节点,val是根节点,node可以一直向下延伸,只要与根节点的val相同.
            if(node == null){
                return 0;
            }
            int left = dps(node.left, node.val);//以左儿子作为起始的左边路径长度,注意这里是儿子节点自己的val.
            int right = dps(node.right, node.val);  //指的是下面两儿子边的路径长度
            res = Math.max(res, left + right); //这里是left与right初始默认为从下到上的两边长度.,相加是表示左右长度,因为长度是节点数-1,所以这里不加1.
            if(node.val == val){  //与父节点相同,则深度+1;
                return Math.max(left, right) + 1;
            }
            return 0;
        }
    }
}
