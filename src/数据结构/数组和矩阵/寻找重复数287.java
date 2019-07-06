package 数据结构.数组和矩阵;
//【笔记】这道题（据说）花费了计算机科学界的传奇人物Don Knuth 24小时才解出来。并且我只见过一个人（注：Keith Amling）用更短时间解出此题。
//快慢指针，一个时间复杂度为O(N)的算法。
//其一，对于链表问题，使用快慢指针可以判断是否有环。
//其二，本题可以使用数组配合下标，抽象成链表问题。但是难点是要定位环的入口位置。
//举个例子：nums = [2,5, 9 ,6,9,3,8, 9 ,7,1]，构造成链表就是：2->[9]->1->5->3->6->8->7->[9]，也就是在[9]处循环。
//其三，快慢指针问题，会在环内的[9]->1->5->3->6->8->7->[9]任何一个节点追上，不一定是在[9]处相碰，事实上会在7处碰上。
//其四，必须另起一个for循环定位环入口位置[9]。这里需要数学证明。
//http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
//对“其四”简单说明一下，既然快慢指针在环内的某处已经相碰了。那么，第二个for循环遍历时，res指针还是在不停的绕环走，但是必定和i指针在环入口处相碰。
public class 寻找重复数287 {
    class Solution {
        public int findDuplicate(int[] nums) {
            //把每个nums的值当做下一个数的索引指针.相当于找环形链表的入口
            int slow = nums[0];
            int fast = nums[nums[0]];  //这边必须是快比慢多一个位置,因为这样下面循环才能进行.
            while (fast != slow) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;  //现在是相遇了开始找入口,##因为初始fast多一个位置,这边就要多走一个位置,所以初始为0而不是nums[0]
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }
    }
}
