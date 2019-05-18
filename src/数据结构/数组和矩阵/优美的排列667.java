package 数据结构.数组和矩阵;

import java.util.HashMap;
import java.util.Map;

//####再看!!!???????
public class 优美的排列667 {
    class Solution {
        //完全没有懂!!!!!
        public int[] constructArray(int n, int k) {
            int[] res = new int[n];
            for (int i = 0, l = 1, r = n; l <= r; i++) {
                res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
            }
            return res;
        }
    }

}
