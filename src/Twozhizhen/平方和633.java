package Twozhizhen;
//j从根号c开始往回,i从0向后
public class 平方和633 {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);

        while (i <= j) {
            int sum = i * i + j * j;  //sum是变化的,放在while中
            if (sum == c) {
                return true;
            } else if (sum < c) { //最初i=0时,c强转时截下了一些
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

}
