package leetcode;

/**
 * 对链表进行插入排序
 *
 * @author yx
 * @create 2019-04-01  19:56
 **/
public class Q147 {
    //设置pre来记录当前节点的前置节点，
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head;
        ListNode cur = pre.next;
        while(cur!=null){
            ListNode node = dummy;
            while(node.next!=cur && node.next.val<cur.val){
                node = node.next;
            }
            //插入
            if(node.next!=cur){
                ListNode tmp = node.next;
                node.next = cur;
                pre.next = cur.next;
                cur.next = tmp;
                cur = pre.next;
            } else{//保持原状
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
