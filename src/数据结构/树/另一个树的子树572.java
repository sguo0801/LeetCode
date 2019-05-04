package 数据结构.树;

public class 另一个树的子树572 {
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
        public boolean isSubtree(TreeNode s, TreeNode t) {
            //就是新建一个方法判断是否为相同树即可.然后从s的根开始向下找s的子树使其与t相同
            if(s == null){
                return false;
            }

            if(isSame(s, t)){
                return true;  //说明s与t完全相同.
            }
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        private boolean isSame(TreeNode s, TreeNode t){
            if(s == null && t == null){
                return true;
            }
            if(s == null || t == null){
                return false;
            }

            if(s.val != t.val){
                return false;
            }
            return isSame(s.left, t.left) && isSame(s.right, t.right);
        }
    }
}
