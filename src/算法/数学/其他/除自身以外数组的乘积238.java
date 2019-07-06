package 算法.数学.其他;
//因为空间复杂度要求O(1)、不能使用除法，因此一定需要在乘法过程中得到所有答案；
//我们可以将res数组列成乘积形式，形成一个矩阵，可以发现矩阵次主角线全部为1（因为当前数字不相乘，因此等价为乘1）；
//因此，我们分别计算矩阵的上三角和下三角，并且在计算过程中储存过程值，最终可以在遍历2遍nums下完成结果计算。
//res
//res[0] =	1	num[1]	...	num[n-2]	num[n-1]
//res[1] =	num[0]	1	...	num[n-2]	num[n-1]
//...	...	...	...	num[n-2]	num[n-1]
//res[n-2] =	num[0]	num[1]	...	1	num[n-1]
//res[n-1] =	num[0]	num[1]	...	num[n-2]	1
//先是下三角,再是上三角.
public class 除自身以外数组的乘积238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int p = 1;
            int q = 1;   //p,q作为桥梁.初始为1
            int[] res = new int[n];
            for(int i = 0; i < n; i++){  //下三角遍历结束,则res[n-1]这个数已经赋值结束啦
                res[i] = p;  //下三角开始赋值,不是*=
                p *= nums[i];  //保留num数组值 //最后一个p=24没用.
            }
            for(int i = n - 1; i > 0; i--){ //##注意是--,从下往上
                q *= nums[i];
                res[i-1] *= q;  //上三角则就是*=,取得最后的结果.
            }
            return res;
        }
    }
//    class Solution {
//        public int[] productExceptSelf(int[] nums) {
//            int n = nums.length;
//            int[] res = new int[n];
//            res[0] = 1;
//            for(int i = 1; i < n; i++){
//                res[i] = res[i-1] * nums[i-1];
//            }
//
//            int right = 1;
//            for(int j = n-1; j >= 0; j--){
//                res[j] *= right;
//                right *= nums[j];
//            }
//            return res;
//        }
//    }
}
