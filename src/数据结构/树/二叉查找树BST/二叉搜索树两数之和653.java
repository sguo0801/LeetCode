package 数据结构.树.二叉查找树BST;

import java.util.ArrayList;
//使用中序遍历得到有序数组之后，再利用双指针对数组进行查找。
//应该注意到，这一题不能用分别在左右子树两部分来处理这种思想，因为两个待求的节点可能分别在左右子树中。
public class 二叉搜索树两数之和653 {
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
        public boolean findTarget(TreeNode root, int k) {
            ArrayList<Integer> list = new ArrayList<>();  //作为保存的有序数组.
            toOrder(root, list);  //把树中值有序排进列表.
            int left = 0;
            int right = list.size()-1;
            while(left < right){  //代表有序列表索引,所以相同则说明找完了
                int sum = list.get(left) + list.get(right);
                if(sum == k){
                    return true;
                }else if(sum < k){
                    left++;
                }else{
                    right--;
                }
            }
            return false;
        }

        private void toOrder(TreeNode root, ArrayList<Integer> list){
            //中序遍历进行排序并放进list中.
            if(root == null){  //递归第一项任务先把截止条件写好.一般是root==null之类的
                return;
            }
            toOrder(root.left, list);
            list.add(root.val);
            toOrder(root.right, list);
        }
    }
}
