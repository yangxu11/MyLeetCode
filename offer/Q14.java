package leetcode.offer;

/**
 * 链表中的倒数第K个节点
 *
 * @author yx
 * @create 2019-05-03  11:24
 **/
public class Q14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while(k>0){
            node  = node.next;
            if(node==null){
                return null;
            }
            --k;

        }
        ListNode h = dummy;
        while(node!=null){
            h = h.next;
            node = node.next;
        }
        return h;
    }
}
