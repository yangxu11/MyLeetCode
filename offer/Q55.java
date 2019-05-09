package leetcode.offer;

/**
 * 链表中环的入口
 *
 * @author yx
 * @create 2019-05-09  20:33
 **/
public class Q55 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null) return null;
        ListNode slow = pHead;
        ListNode fast = pHead;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = pHead;
                while(fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
