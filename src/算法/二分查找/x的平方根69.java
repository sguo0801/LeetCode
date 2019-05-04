package 算法.二分查找;

public class x的平方根69 {
        public int mySqrt(int x) {
            if(x <= 1){
                return x;
            }
            int left = 1;
            int right = x;
            while(left <= right){  //因为有小数,两者会交叉,结束循环时right在左.所以带=..如果没有=一般下面的left和right可能会有=mid的情况.
                int mid = left + (right - left) / 2;
                int sqrt = x / mid;
                if(sqrt == mid){
                    return mid;
                }else if(sqrt < mid){
                    right = mid - 1;
                }else{
                    left = mid + 1;  //一般还是要+1,或者-1,除非值可能是结果,比如有重复
                }
            }
            return right;
        }
}
