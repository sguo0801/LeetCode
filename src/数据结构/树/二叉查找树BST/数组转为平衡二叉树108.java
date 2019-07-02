package 数据结构.树.二叉查找树BST;
//思路就是有序列表,直接二分法就可以.
public class 数组转为平衡二叉树108 {
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
        public TreeNode sortedArrayToBST(int[] nums) {

            //构造平衡二叉树,就是找每个子树的根,且根是各段中间的值,左右个数几乎相同,相当于均分了长度,即高度差不会大于1
            return toFeed(nums, 0, nums.length - 1);  //注意右侧是有端点索引为length-1.
            //return root;  //在方法中返回树节点.
        }

        private TreeNode toFeed(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }

            int mid = (right + left) >> 1;//求mid或者用 (right + left) >> 1;或者用left+(right-left)/2;不要右边用位运算,这样混合了十进制与二进制运算,不正确
            TreeNode root = new TreeNode(nums[mid]);
            root.left = toFeed(nums, left, mid - 1);
            root.right = toFeed(nums, mid + 1, right);
            return root;
        }
    }
}
