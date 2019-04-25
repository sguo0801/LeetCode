package 动态规划.斐波那契数列;
//第i个楼梯可以从第i-1和i-2个楼梯再走一步到达，走到第i个楼梯的方法数为走到第i-1和第i-2个楼梯的方法数之和。
public class 爬楼梯70 {
        public int climbStairs(int n) {
            int[] a = new int[n+1];
            a[0] = 1;
            a[1] = 1;
            for(int i = 2; i < n+1; i++){
                a[i] = a[i - 1] + a[i - 2];  //使用数列则是空间复杂度为on.
                //法二,用两个变量表示前两个数,后面,进行迭代.这样空间复杂度为o1.
            }
            return a[n];
        }
}
