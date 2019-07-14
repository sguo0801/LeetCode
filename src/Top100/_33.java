package Top100;

public class _33 {
    class Solution {
        public int search(int[] nums, int target) {
            //二分查找
            int left = 0;
            int right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] == target){
                    return mid;
                }

                //先看数组的序列如何
                //再分析target的情况,必须放在一个升序中才可以
                if(nums[mid] >= nums[left]){  //注意是有=情况
                    if(target >= nums[left] && target < nums[mid]){  //注意左侧边界有=
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                } else{  //现在是mid右侧为升序,这两种序列情况必有一种成立
                    if(target <= nums[right] && target > nums[mid]){  //注意右边界有=
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }

            }
            return -1;
        }
    }
}
