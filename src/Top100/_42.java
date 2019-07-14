package Top100;
//接雨水思路,就是看两侧挡板,然后小的那边开始加水,加过水才能变化left或right.for循环没有递增条件,也可以用while循环.
public class _42 {
    class Solution {
        public int trap(int[] height) {
            if(height == null || height.length == 0){
                return 0;
            }

            int leftMax = Integer.MIN_VALUE;
            int rightMax = Integer.MIN_VALUE;
            int res = 0;
            //具体:比如从左边开始,如果高度变高则max发生变化,当遇到小的,且右边的max比较大.这时可以加上左边max-左边这时高度
            for(int left = 0, right = height.length - 1; left <= right; ){  //最后左右相遇时,就是res+0,然后右在左,结束.
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if(leftMax < rightMax){  //木桶原理哪边挡板小,哪边加.
                    res += (leftMax - height[left]);  //这时就是在左边加,如果刚更新高度,则肯定死+0,但是如果left++后,就可能加差值啦.
                    left++;    //此时height=0,但是leftMax不变,则可以加水.
                }else{
                    res += (rightMax - height[right]);
                    right--;
                }

            }
            return res;
        }
    }
    //while循环
    //public int trap(int[] A){
    //    int a=0;
    //    int b=A.length-1;
    //    int max=0;
    //    int leftmax=0;
    //    int rightmax=0;
    //    while(a<=b){
    //        leftmax=Math.max(leftmax,A[a]);
    //        rightmax=Math.max(rightmax,A[b]);
    //        if(leftmax<rightmax){
    //            max+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
    //            a++;
    //        }
    //        else{
    //            max+=(rightmax-A[b]);
    //            b--;
    //        }
    //    }
    //    return max;
    //}
}
