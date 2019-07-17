package Top100;
//二叉树中任意节点连接的最大路径和
//时间复杂度：O(N)O(N) 其中 NN 是结点个数。我们对每个节点访问不超过 2 次。
//空间复杂度：O(\log(N))O(log(N))。我们需要一个大小与树的高度相等的栈开销，对于二叉树空间开销是 O(\log(N))O(log(N))。
public class _124 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
//思路,从最下面的叶子节点开始往根看,找其子树的路径和(叶子节点就是本身).
//比对根节点左子树和右子树的较大值,最后的返回最大值,肯定是左+右+node.val得来的.通用的算法,因为哪怕只有最左下角一个正值,那也是第一次0+0+val得到的
//后面更新好max后,每上升一个节点,继续比较该节点max值,并进行比较.递归函数就是求左或者右子树与本身的和的最大值,在这个递归的过程中得到整个书的最大路径和.
    class Solution {
        int maxvalue = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            getSonPath(root);  //只是为了递归,这个值本身只是为根的单侧子树和最大值.这个值不一定为整棵树的最大路径和.可以不用赋给变量.这样写就可以
            return maxvalue;
        }

        private int getSonPath(TreeNode node){
            if(node == null){
                return 0;
            }
            int left = Math.max(0, getSonPath(node.left));  //这边是看左子树的值是否>0;如果都是负值,则左子树抛弃不会添加到路径中.
            int right = Math.max(0, getSonPath(node.right));
            maxvalue = Math.max(maxvalue, left+right+node.val);  //从最下层节点开始向上更新maxvalue;如果当前节点是叶子节点,这里left和right为0.
            return Math.max(left, right) + node.val;   //返回的是单侧包括当前节点值的路径和.
        }
    }
}
