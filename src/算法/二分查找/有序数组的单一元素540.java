package 算法.二分查找;

public class 有序数组的单一元素540 {
    //法一,通过异或^,相同则抵消,最后剩下的就是那个唯一的数,该方法适用于两个单独的数,分成两个数组即可.法二,二分o(logn)时间不好用.
        public int singleNonDuplicate(int[] nums) {
            int res = 0;
            for(int a : nums){
                res ^= a;
            }
            return res;
        }
}
