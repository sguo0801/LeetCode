package 数学.其他;
//平方序列：1,4,9,16,..
//间隔：3,5,7,...
//间隔为等差数列，使用这个特性可以得到从 1 开始的平方序列。
public class 有效的完全平方数367 {
    class Solution {
        public boolean isPerfectSquare(int num) {
            int temp = 1;
            while(num > 0){
                num -= temp;
                temp += 2;
            }
            return num == 0;
        }
    }
}
