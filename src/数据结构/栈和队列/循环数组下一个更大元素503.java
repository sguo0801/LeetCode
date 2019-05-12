package 数据结构.栈和队列;

import java.util.Arrays;
import java.util.Stack;

public class 循环数组下一个更大元素503 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] res = new int[nums.length];
            Arrays.fill(res, -1);  //默认是-1;也就是最后还在栈中不管的,置为-1
            Stack<Integer> s = new Stack<>();  //依然是放数组索引的栈
            for(int i = 0; i < nums.length * 2; i++){  //这边是循环数组,索引循环两边即可
                int num = nums[i%nums.length];
                while(!s.empty() && nums[s.peek()] < num){
                    res[s.pop()] = num;  //相当于把739题温度中的索引差,变成了定值num
                }
                if(i < nums.length){
                    s.push(i);  //最后把满足小于n的索引放入,等待后面(包括第二圈)的值.
                }
            }
            return res;
        }
    }
}
