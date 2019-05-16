package 数据结构.字符串;

public class 回文数9 {
    class Solution {
        public boolean isPalindrome(int x) {
            //将右侧反转,如果是121,右侧就是12(后往前看),如果是1221,右侧就是12.
            if (x == 0) {
                return true;
            }
            if (x < 0 || x % 10 == 0) {
                return false;   //这边是把0已经排除在外啦
            }

            int right = 0;
            while (x > right) {
                right = right * 10 + x % 10;  //乘10是把右侧的数为上升,从1变成10.整体看就是从1变成12的过程
                x /= 10;  //左侧也后往前截断.
            }
            return x == right || x == right / 10;  //偶数位就是左边,如1221,奇数位就是右边,如121
        }
    }
}
