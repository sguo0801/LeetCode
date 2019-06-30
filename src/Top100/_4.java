package Top100;
//https://zhuanlan.zhihu.com/p/70654378
public class _4 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            /**
             如果两个数组的中位数 mid1 < mid2, 则说明合并后的中位数位于 num1.right + num2之间
             否则合并后的中位数位于 nums2.right + nums1 之间 (right 是相对于 mid 而言的)
             getKth 函数负责找到两个数组合并(假设)后有序的数组中的第 k 个元素, k 从 1 开始计算
             **/
            if(nums1.length == 0 && nums2.length == 0) return 0.0;
            int m = nums1.length, n = nums2.length;
            // l: 合并后数组的左半部分的最后一个数 r: 合并后数组的右半部分的第一个数
            int l = (m+n+1) / 2;  //索引是从1开始计算
            int r = (m+n+2) / 2;
            // 如果 m+n 是奇数 getKth 的返回值是相同的, 是偶数则是合并后数组的中间两个数
            if(l == r) return getKth(nums1, 0, nums2, 0, l);
            return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
        }

        private double getKth(int[] nums1, int st1, int[] nums2, int st2, int k) {
            // 边界情况, 如果 nums1数组已经穷尽了, 则只能返回 nums2 中的第 k 个元素
            if(st1 > nums1.length-1) return nums2[st2 + k - 1];  //数组1为0个元素,这边数组索引是从0开始的,所以-1.st1是从该数组第几个位置开始找
            if(st2 > nums2.length-1) return nums1[st1 + k - 1];
            // 边界情况, k = 1 则返回两个数组中最小的那个,k=1,就是第一个数,也就是排序后最小的数
            if(k == 1) return Math.min(nums1[st1], nums2[st2]);
            // 在 nums1 和 nums2 当前范围内找出 mid1 和 mid2 判断舍弃哪半部分
            int mid1 = Integer.MAX_VALUE;//必须要有
            int mid2 = Integer.MAX_VALUE;
            if(st1 + k/2 - 1 < nums1.length) mid1 = nums1[st1 + k/2 - 1];
            if(st2 + k/2 - 1 < nums2.length) mid2 = nums2[st2 + k/2 - 1];
            // mid1 < mid2 在 nums1.right 和 nums2 之间搜索, 丢掉 k/2 个数.
            if(mid1 < mid2)  //确实不确定num1.right与num2.left的大小.但是比较两个数组中位数可以知道真正的中位数不在小的中位数的左侧,k为中位数的位置相当于折半,k/2就是一个数组的一半.
                return getKth(nums1, st1 + k/2, nums2, st2, k - k/2);//丢掉的是前k/2个数,都是小的数,再从后面递归找第k/2即为要的中位数.
            else
                return getKth(nums1, st1, nums2, st2 + k/2, k - k/2);
        }
    }
}
