package 贪心思想;

public class 种花问题605 {
        public boolean canPlaceFlowers(int[] flowerbed, int n) { //抠掉最初和末端,在中间的时候,只有前后均为0才可以种花
            int times = 0;
            for(int i = 0; i < flowerbed.length; i++){
                if(flowerbed[i] == 1){
                    continue;
                }
                int pre = i == 0 ? 0 : flowerbed[i - 1];
                int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];  //就是如果是最前端,前面没有土即默认为前面不影响种花,末端也一样,边界而已
                if(pre == 0 && next == 0){
                    times++;
                    flowerbed[i] = 1; //计数后进行种花填充
                }
            }
            return times >= n;
        }
}
