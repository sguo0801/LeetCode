package Top100;
//跳跃游戏.
public class _55 {
    class Solution {
        public boolean canJump(int[] nums) {
            int max = 0;  //max指的是能到达的最大位置索引(当前值与索引和),这题,如果当前索引比最大能到的位置索引大,说明,不可以再向后走啦.比如32104中,i=3时,max=3,当i=4,则i>max,即无法到达
            for(int i = 0; i < nums.length; i++){
                if(i > max){
                    return false;
                }
                max = Math.max(max, nums[i] + i);
            }
            return true;
        }
    }
}
