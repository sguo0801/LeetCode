package 数据结构.位运算;

public class 汉明距离461 {
    class Solution {
        public int hammingDistance(int x, int y) {
            int z = x ^ y;  //出来的1是两边不同的位置
            int count = 0;
            while(z != 0){
                z &= (z-1);  //把最低的1去掉
                count++;
            }
            return count;
        }
    }
}
