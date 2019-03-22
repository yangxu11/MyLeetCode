package leetcode;
//删除链表中倒数第N个节点
public class Q19 {
    //双指针，二者相差N，当后一个到达最后时，前一个的next为要删除的节点
    //注意要从head之前的空node开始，否则第一个和最后一个删除会出问题
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode empty = new ListNode(0);
        empty.next = head;
        ListNode first = empty;
        ListNode node = empty;
        while(n>0){
            node = node.next;
            n--;
        }
        ListNode second = node;
        while(second.next!=null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return empty.next;

    }
}
