package sort;

public class    颜色分类75 {
    public void sortColors(int[] nums) {
        int zero = -1;
        int one = 0;
        int two = nums.length; //这里的zero,one,two指的是指向012的指针.
        while(one < two){ //从两侧往中间移动索引.zero和one是往右,two往左
            if(nums[one] == 0){
                swap(nums, ++zero, one++); //zero始终在one前面.
            }else if(nums[one] == 2){
                swap(nums, --two, one);//如果交换后one是新元素,则one不变.后面换过来的元素要重新看值,这里第一次错了
            }else{
                one++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){  //swap只是交换两个数,索引在交换过程中此时不改变.
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
