package 数据结构.树;

public class 二叉树中第二小节点值671 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    //对于左右子节点，如果它们的值与父节点值相同，则需要使用递归来查找下一个候选，否则使用它们的节点值作为候选。
    class Solution {
        public int findSecondMinimumValue(TreeNode root) {  //返回的都是子节点的小值
            if(null == root){
                return -1;
            }
            if(root.left == null && root.right == null){
                return -1;
            }

            int left = root.left.val;
            int right = root.right.val;
            if(left == root.val){
                left = findSecondMinimumValue(root.left); //如果子节点与根相同,说明同小,则要向下递归找更小的值
            }

            if(right == root.val){
                right = findSecondMinimumValue(root.right);
            }

            if(left != -1 && right != -1){ //说明向下都有递归的值
                return Math.min(left, right);
            }
            if(left != -1){ //说明right为-1,但是上面right不能为null,要与root同值,说明下面是没有子节点的.所以只能返回左边的left
                return left;
            }else{
                return right;
            }

        }
    }
}
