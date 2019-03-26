package leetcode;

/**
 * 反转链表
 *
 * @author yx
 * @create 2019-03-26  20:46
 **/
public class Q206 {
    //从头开始反转
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
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
