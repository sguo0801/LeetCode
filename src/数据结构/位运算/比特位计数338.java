package 数据结构.位运算;
//去掉低位的1再加上一个1.
public class 比特位计数338 {
    class Solution {
        public int[] countBits(int num) {
            int[] res = new int[num+1]; //0~num
            for(int i = 1; i <= num; i++){//0默认为0
                //对于数字 6(110)，它可以看成是 4(100) 再加一个 2(10)，因此 dp[i] = dp[i&(i-1)] + 1;
                res[i] = res[i&(i-1)] + 1;  //i&(i-1)指的是去掉最低位1的剩下数,
            }
            return res;
        }
    }
}
