package leetcode.offer;

/**
 * 两个链表的第一个公共节点
 *
 * @author yx
 * @create 2019-05-07  17:51
 **/
public class Q36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(pHead1!=pHead2){
            pHead1 = pHead1==null ? p2 : pHead1.next;
            pHead2 = pHead2==null ? p1 : pHead2.next;
        }
        return pHead1;
    }
}
