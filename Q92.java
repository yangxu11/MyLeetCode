package leetcode;

/**
 * 反转链表II
 *
 * @author yx
 * @create 2019-03-26  20:45
 **/
public class Q92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count=1;
        ListNode pre = dummy;
        while(count<m){
            pre = pre.next;
            count++;
        }
        ListNode cur = pre.next;
        int times = n - m;
        while(times>0){
            ListNode tmp = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = tmp;
            times--;
        }
        return dummy.next;
    }
}
