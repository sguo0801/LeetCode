package 算法.二分查找;

public class 寻找旋转排序数组中的最小值153 {
        public int findMin(int[] nums) {
            int n = nums.length;
            int l = 0;
            int r = n - 1;
            while(l < r){
                int mid = l + (r - l) / 2;
                if(nums[mid] < nums[r]){
                    r = mid;
                }else if (nums[mid] == nums[r]){
                    r--;
                }else{
                    l = mid + 1;
                }
            }
            return nums[r];
        }
}
