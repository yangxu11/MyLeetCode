package leetcode;

/**
 * 移除链表中的元素
 *
 * @author yx
 * @create 2019-04-05  10:30
 **/
public class Q203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while(node.next!=null){
            if(node.next.val == val){
                node.next = node.next.next;
            } else{
                node = node.next;
            }
        }
        return dummy.next;
    }
}
