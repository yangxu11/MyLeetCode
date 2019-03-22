package leetcode;
//两两交换链表中的节点
public class Q24 {
    //链表节点的交换，画图
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode empty = new ListNode(0);
        empty.next = head;
        ListNode first = empty;
        ListNode second = head;
        while(second!=null && second.next != null){
            ListNode next = second.next.next;
            first.next = second.next;
            first.next.next = second;
            second.next = next;
            first = second;
            second = first.next;
        }
        return empty.next;
    }
}
