package Top100;
//卓见！ 因为Array中的元素是从1到n，所以减1将是0到n-1，它们是数组的索引。
//以输入[4.3.2.7.8.2.3.1]为例，通过减1，它变为[3.2.1.6.7.1.2.0]，这是一个索引数组。
//对于第一次迭代
//当i = 0时，它将nums [3]标记为负数，数组变为[4.3.2.-7.8.2.3.1]。
//当i = 1时，它将nums [2]标记为负数，数组变为[4.3.-2.-7.8.2.3.1]。
//当i = 2时，它将nums [1]标记为负数，数组变为[4.-3.-2.-7.8.2.3.1]。
//当i = 3时，它将nums [6]标记为负数，数组变为[4.-3.-2.-7.8.2.-3.1]。
//...
//...
//当i = 6时，它将nums [0]标记为负数，数组变为[-4.-3.-2.-7.8.2.-3.-1]。
//
//对于第二次迭代
//找到nums [4] = 8和nums [5] = 2> 0;
//这意味着4和5不在索引数组[3.2.1.6.7.1.2.0]中。
//通过添加1,5和6不在输入[4.3.2.7.8.2.3.1]
//返回[5.6]
import java.util.ArrayList;
import java.util.List;

public class _448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
