package 数据结构.数组和矩阵;
//448,442题目要下次做掉.
public class 错误的集合645 {
    //新思路:不需要交换
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length];
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            count[nums[i]-1]++;// 因为数大1,所以-1当做索引
        }
        for(int i=0;i<count.length;i++){
            if(count[i]==2)
                res[0]=i+1;
            if(count[i]==0)
                res[1]=i+1;
        }
        return res;
    }
//    class Solution {
//        public int[] findErrorNums(int[] nums) {
//            //通过交换不合理的数组,使其有序,比如从2124到1224.
//            for (int i = 0; i < nums.length; i++) {
//                while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {  //数字是从1开始,索引从0开始.
//                    swap(nums, i, nums[i] - 1);
//                }
//            }
//
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] != i + 1) {   //这题目关键是,nums数组中的数就是比索引大1.所以,不符合的就是重复值,该处的正确值为i+1.
//                    return new int[]{nums[i], i + 1};
//                }
//            }
//
//            return null;
//        }
//
//        private void swap(int[] nums, int a, int b) {
//            int temp = nums[a];
//            nums[a] = nums[b];
//            nums[b] = temp;
//        }
//    }
}
