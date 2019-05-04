package leetcode.offer;

/**
 * 反转链表
 *
 * @author yx
 * @create 2019-05-04  10:07
 **/
public class Q15 {
    public ListNode ReverseList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode dummy = new ListNode(0);
        ListNode node = head;
        dummy.next = head;
        while(head.next!=null){
            ListNode tmp = head.next;
            head.next = head.next.next;
            dummy.next = tmp;
            tmp.next = node;
            node = tmp;
        }
        return dummy.next;
    }
}
