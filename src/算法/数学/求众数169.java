package 算法.数学;

public class 求众数169 {
    class Solution {
        public int majorityElement(int[] nums) {
            //士兵打仗问题,遇到相同的是则+1,遇到不同的则-1,为0时,则换数且默认为1.
            int temp = 0; //为了从第一个值开始遍历,避免重复+1.所以从0开始
            int cur = nums[0];
            for(int num : nums){
                cur = temp == 0 ? num : cur;  //先看是不是为0,再进行+-,为0,则换成新的值.
                temp = cur == num ? temp + 1 : temp - 1;  //如果这里已经更新了新的num,temp应该更新为1,说明有一个当前值.如果num与cur相同,也是直接+1.
            }
            return cur;  //众数超过总数量的一般,所以最后剩下的就是那个众数.
        }
    }
}
