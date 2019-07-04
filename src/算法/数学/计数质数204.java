package 算法.数学;
//求最大公约数,先判断a,b大小,都是大的在左边,小的放右边,右边为0,则返回a即为所求
//int gcd(int a, int b) {
//    return b == 0 ? a : gcd(b, a % b);原理：x=ky+b,则f(x,y)=f(y,b)。
//}
//求最小公倍数为两数的乘积除以最大公约数。
//int lcm(int a, int b) {
//    return a * b / gcd(a, b);
//}

//使用位操作和减法求解最大公约数  ??不是很理解
//https://yq.aliyun.com/articles/3797
//对于 a 和 b 的最大公约数 f(a, b)，有：
//
//如果 a 和 b 均为偶数，f(a, b) = 2*f(a/2, b/2);
//如果 a 是偶数 b 是奇数，f(a, b) = f(a/2, b);
//如果 b 是偶数 a 是奇数，f(a, b) = f(a, b/2);
//如果 a 和 b 均为奇数，f(a, b) = f(b, a-b);
//乘 2 和除 2 都可以转换为移位操作
//public int gcd(int a, int b) {
//    if (a < b) {
//        return gcd(b, a);
//    }
//    if (b == 0) {
//        return a;
//    }
//    boolean isAEven = isEven(a), isBEven = isEven(b);
//    if (isAEven && isBEven) {
//        return 2 * gcd(a >> 1, b >> 1);
//    } else if (isAEven && !isBEven) {
//        return gcd(a >> 1, b);
//    } else if (!isAEven && isBEven) {
//        return gcd(a, b >> 1);
//    } else {
//        return gcd(b, a - b);
//    }
//}
//思路:采用厄拉多塞筛法
//介绍：改算法在寻找素数时，采用了一种与众不同的方法：先将 2－N 的各数放入表中，然后在 2 的上面画一个圆圈，然后划去 2 的其他倍数；
// 第一个既未画圈又没有被划去的数是 3，将它画圈，再划去 3 的其他倍数；现在既未画圈又没有被划去的第一个数是 5，将它画圈，并划去5的其他倍数……
// 依次类推，一直到所有小于或等于N的各数都画了圈或划去为止。
//这时，表中画了圈的以及未划去的那些数正好就是小于 N 的素数。
//普通方法会出现超时，所以只能以空间换时间，采用一个数组来进行标记是否是质数。

public class 计数质数204 {
    class Solution {
        public int countPrimes(int n) {  //注意是小于n的
            boolean[] isFeed = new boolean[n+1];  //可以是n,后面i*j<n即可.
            int count = 0;
            for(int i = 2; i < n; i++){  //n为2时,则不满足i<n,直接退出循环,count=0
                if(!isFeed[i]){  //默认为false;i为质数,如果为true,说明被标记过
                    count++;
                    for(int j = 1; j * i <= n; j++){  //i的整数倍均不是质数,j从1或者2开始均可,不影响
                        isFeed[j*i] = true;
                    }
                }
            }
            return count;
        }
    }
}
