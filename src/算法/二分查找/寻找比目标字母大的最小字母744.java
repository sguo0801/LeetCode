package 算法.二分查找;

public class 寻找比目标字母大的最小字母744 {
        public char nextGreatestLetter(char[] letters, char target) {
//            if(letters.length == 0){ //可以没有
//                return letters[0];
//            }
//            if(target >= letters[letters.length - 1]){
//                return letters[0];
//            }
            int left = 0;
            int right = letters.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(letters[mid] <= target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            return left < letters.length ? letters[left] : letters[0];  //最后都落到left上,如果超过长度,则返回第一个值.
        }
}
