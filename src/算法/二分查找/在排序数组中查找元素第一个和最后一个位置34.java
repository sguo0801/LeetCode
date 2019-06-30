package 算法.二分查找;
//像排序数组中元素出现次数,以及找位置的题目,均可以用一个double类型的前后值来进行做差,得到的是两个double插入在原数组中的位置,出现次数则直接两者做差即可,
// 如果是求位置,则前一个double的位置并不是元素的起始位置,而是要+1,而后一个double位置是该元素的最后一个位置
public class 在排序数组中查找元素第一个和最后一个位置34 {
        public int[] searchRange(int[] nums, int target) {
            int a = index(nums, target - 0.5);
            int b = index(nums, target + 0.5);
            if(a >= b){  //不存在目标值,则并不是一个区间形式.即a>=b.
                return new int[]{-1, -1};
            }
            return new int[]{a + 1, b};
        }

        private int index(int[] nums, double t){
            int l = 0;
            int r = nums.length - 1;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(nums[mid] < t){  //如果恰好t在mid和mid+1,之间也没事,最后r还是会定在mid的位置.也就是前一个数的最后一个位置
                    l = mid + 1;
                }else if(nums[mid] > t){
                    r = mid - 1;
                }
            }
            return r; //只能是r,最后一步是r往回走一步,确定插入的位置(覆盖住前一个数的最后一个位置).
        }
}
