package leetcode;

/**
 * 回文链表
 *
 * @author yx
 * @create 2019-04-10  17:04
 **/
public class Q234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = reverse(slow.next);
        slow.next = null;
        ListNode left = head;
        while(right!=null){
            if(left.val!=right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head.next!=null){
            ListNode tmp = dummy.next;
            dummy.next = head.next;
            head.next = head.next.next;
            dummy.next.next = tmp;
        }
        return dummy.next;
    }
}
