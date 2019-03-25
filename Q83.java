package leetcode;
//删除排序链表中的重复项
public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null){
            if(fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
