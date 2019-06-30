package Top100;
//如果没有看到示例，我认为任何人都无法理解这个解决方案，这里有一个例子：
//2,3,6,5,4,1
//
//解：
//步骤1，从右到左，找到第一个不按升序增加的数字。在这种情况下是3。
//Step2，这里我们可以有两种情况：
//
//我们找不到数字，所有数字都按升序增加。这意味着这种排列是最后的排列，我们需要旋转回第一个排列。所以我们反转整个数组，例如，6,5,4,3,2,1我们把它变成1,2,3,4,5,6。
//
//我们可以找到数字，然后下一步，我们将从最右边开始到左边，尝试找到大于3的第一个数字，在这种情况下它是4。
//然后我们交换3和4，列表转为2,4,6,5,3,1。
//最后，我们在4的右边反转数字，最后得到2,4,1,3,5,6。
//
//时间复杂度为：O（3 * n）= O（n）。
//
//最后，我不知道如何提出这个解决方案。这里只是通过示例来理解解决方案。希望这可以帮助。
public class _31 {
    class Solution {
        public void nextPermutation(int[] nums) {
            if(nums == null || nums.length == 0){
                return;
            }

            int n = nums.length - 1;  //最后一个数的索引
            int p = -1;   //想找到的逆序第一个非递增的数的索引
            int pv = 0;   //索引为p的数值

            for(int i = n-1; i >= 0; i--){
                if(nums[i] < nums[i+1]){
                    //找到了
                    p = i;
                    pv = nums[i];
                    break;
                }
            }

            if(p == -1){
                //没找到
                reverse(nums, 0, n);
                return;
            }

            for(int i = n; i >= 0; i--){
                if(nums[i] > pv){
                    swap(nums, i, p);  //只是交换值,p和i并不改变.
                    break;
                }
            }

            reverse(nums, p+1, n);
        }

        private void reverse(int[] nums, int a, int b){
            while(a < b){
                swap(nums, a, b);
                a++;
                b--;
            }
        }

        private void swap(int[] nums, int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
