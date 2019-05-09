package leetcode.offer;

/**
 * 删除链表中的重复节点
 *
 * @author yx
 * @create 2019-05-09  20:42
 **/
public class Q56 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode node = pHead;
        ListNode pre = dummy;
        while(node!=null){
            if(node.next!=null && node.next.val == node.val){
                while(node.next!=null && node.next.val==node.val){
                    node = node.next;
                }
                pre.next = node.next;
                node = node.next;
            } else{
                pre = node;
                node = node.next;
            }
        }
        return dummy.next;
    }
}
