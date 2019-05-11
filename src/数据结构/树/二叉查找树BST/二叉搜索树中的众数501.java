package 数据结构.树.二叉查找树BST;

import java.util.ArrayList;

public class 二叉搜索树中的众数501 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private int cur = 1;
        private int max = 1; //数量值,因为递归中发生变化,所以要写在外面作为全局变量
        private TreeNode preNode = null; //有前后比较的就要设个pre节点.作为向后遍历的索引节点.

        public int[] findMode(TreeNode root) {
            //能用ArrayList就不要用HashMap,这里list可以直接添加符合要求的元素,而map还要再比较
            //思路是中序遍历,因为相同肯定连着,然后有记录当前数最大数量值,和之前数最大数量值,作比较进行list添加值.
            ArrayList<Integer> list = new ArrayList<>();  //list中添加的是可能是众数的数值.
            inOrder(root, list);  //list也发生变化,但是是容器,所以放在函数参数中,本身可变,而数字作为形参回来就不会变.
            int[] res = new int[list.size()];
            //这边要使用foreach循环,没有i,所以先建一个索引变量.
            int index = 0;
            for (int num : list) {
                res[index++] = num;
            }
            return res;
        }

        private void inOrder(TreeNode root, ArrayList<Integer> list) {
            if (root == null) {
                return; //递归先写截止条件;
            }
            inOrder(root.left, list);  //二叉搜索树中序遍历则为有序
            if (preNode != null) {
                if (root.val == preNode.val) {
                    cur++;
                } else {  //不等说明换值啦.
                    cur = 1;
                }
            }
            //这里不再上面的判断条件中,第一个值肯定进入list,即便只有一个
            if (cur > max) {  //说明当前节点值为最多
                max = cur;
                list.clear(); //众数值开始改变,先清空
                list.add(root.val);  //天剑符合要求的众数值
            } else if (cur == max) {  //##第一个数在这里
                list.add(root.val);  //两个数量均为最大
            }

            preNode = root; //向后遍历
            inOrder(root.right, list);
        }
    }
}
