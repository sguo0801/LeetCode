package Top100;

public class _152 {
        //作者补充:代码可以处理这种情况。 对于零值，imax和imin必须都为零，因为任何数字的零次为零。 请参考imax和imin的定义。
        public static int maxProduct(int[] nums) {
            //思路:记录当前nums[i]为结尾的最大最小值,然后比较确定要不要之前的最大最小值
            //最小值是为了遇到负数可以先交换最大最小值,然后得到最小的负数值,当再次遇到负数可以乘出更大的正数.
            int res = nums[0];
            //要分别初始化,不能写imax, imin=nums[0],这样imax并没有初始化.
            for(int i = 1, imax = res, imin = res; i < nums.length; i++){
                //先看当前是不是负值
                if(nums[i] < 0){
                    //swap(imax, imin);  //交换最大最小值###这里是错误的???原因??
                    int temp = imax;
                    imax = imin;
                    imin = temp;
                }

                imax = Math.max(nums[i], imax * nums[i]);
                imin = Math.min(nums[i], imin * nums[i]);  //比如之前是imin=3,imax=6,那么现在遇到-1,先交换3和6,再乘积比较.则最小值现在为-1和-6的最小值.最大值是-1和-3的最大值.最大值自然没有之前的6大,但是没关系,之前的6已经存在了结果res中

                res = Math.max(res, imax);
            }
            return res;
        }
        private static void swap(int a, int b){
            int temp = a;
            a = b;
            b = temp;
        }

        public static void main(String[] args) {
            int[] nums = {-2, 3, -4};
            System.out.println(maxProduct(nums));
        }

}
