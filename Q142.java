package leetcode;
//环形链表II
public class Q142 {
    //快慢指针，先判断是否有环
    //然后将快指针放到头节点，然后快慢指针一起一步一步走，重逢即入口


    //原理：l为循环长度  n为head到入口长度  m为初次重逢的点到入口长度
    //x = n + u*l + m ;  2x = n + v*l + m
    //解得 m+n是l的倍数  n = k*l - m
    //如果把fast放到头节点处，再次重逢
    //  fast 走了 n = k*l - m   slow走了 x*l - m   必在出口处相遇
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                fast = head;
                while(fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
