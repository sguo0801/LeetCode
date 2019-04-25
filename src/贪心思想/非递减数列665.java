package 贪心思想;

public class 非递减数列665 {
        public boolean checkPossibility(int[] nums) {  //跟种花一样,遇到了先修改,主要考虑如何修改不影响后面操作.或者把情况分完整.
            int index = 0;
            for(int i = 1; i < nums.length && index < 2; i++){  //从1开始往前看,毕竟是升序,确保index<2
                if(nums[i] < nums[i - 1]){//发现核心问题,后面再细分情况解决问题
                    index++;
                    if(i >= 2 && nums[i] < nums[i - 2]){  //342的情况
                        nums[i] = nums[i - 1];
                    }else{  //42的情况,前面都是排列好的
                        nums[i - 1]  = nums[i];
                    }
                }
            }
            return index <= 1;
        }
}
