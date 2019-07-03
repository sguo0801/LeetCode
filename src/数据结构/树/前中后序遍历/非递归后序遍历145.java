package 数据结构.树.前中后序遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 非递归后序遍历145 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    //区分,while前序是只有root,中序是root和stack都有,后序是只有stack,root之前排除掉.
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            //##注意,只有后序用LinkedList,前面也要是这个,不能用List<>
            LinkedList<Integer> res = new LinkedList<>();  //##后面用addFirst方法,这边只能前面也时LinkedList,否则方法识别不出来
            Stack<TreeNode> stack = new Stack<>();
            if(root == null){
                return res;
            }
            stack.push(root);  //前序和后序中,栈压入的都是最后的节点,比如前序中压入的right.
            while(! stack.isEmpty()){
                TreeNode temp = stack.pop();
                res.addFirst(temp.val);    //逆着向res中添加.所以此时根虽然是addFirst,但是后面的节点都是在它前面.
                //这边是反着向res中添加值,而栈也是先进后出,所以这边先向栈中放left,保证后面left后出栈,再最后进入res;
                if(temp.left != null){
                    stack.push(temp.left);
                }
                if(temp.right != null){
                    stack.push(temp.right);
                }
            }
            return res;
        }
    }
}
