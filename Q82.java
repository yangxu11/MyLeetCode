package leetcode;
//删除排序链表中的重复项II
public class Q82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast!=null){
            if(fast.next!=null && fast.next.val == fast.val){
                while(fast.next!=null && fast.next.val == fast.val){
                    fast = fast.next;
                }
                slow.next = fast.next;
                fast = fast.next;//slow指针位置不变
            } else{
                slow = slow.next;
                fast = fast.next;
            }
        }
        slow.next = null;
        return dummy.next;
    }
}
