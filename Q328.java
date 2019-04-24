package leetcode;

/**
 * 奇偶链表
 *
 * @author yx
 * @create 2019-04-24  18:05
 **/
public class Q328 {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return head;
        ListNode last = head;
        int count=1;
        while(last.next!=null){
            last = last.next;
            ++count;
        }
        ListNode pre = head;
        ListNode back = last;
        ListNode flag = last;
        if(count%2==0){
            flag = head.next;
        }
        while(pre != flag){
            ListNode node = pre.next;
            pre.next = pre.next.next;
            pre = pre.next;
            back.next = node;
            node.next = null;
            back = back.next;
        }
        return head;

    }
}
