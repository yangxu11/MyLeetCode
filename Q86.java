package leetcode;
//分割链表
public class Q86 {
    //原地分割，不使用额外空间，注意当fast和slow相等时
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast.next!=null){
            if(fast==slow && fast.next.val<x){
                fast = fast.next;
                slow = slow.next;
                continue;
            }
            if(fast.next.val<x){
                ListNode tmp = slow.next;
                slow.next = fast.next;
                fast.next = fast.next.next;
                slow.next.next = tmp;
                slow = slow.next;
            } else{
                fast = fast.next;
            }
        }
        return dummy.next;
    }

    //使用额外空间
    public ListNode partition2(ListNode head, int x) {

        if(head == null) return null;

        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode node = head,leftNode=left,rightNode = right;

        while(node != null){
            if(node.val >= x) {
                rightNode.next = new ListNode(node.val);
                rightNode = rightNode.next;
            } else{
                leftNode.next = new ListNode(node.val);
                leftNode = leftNode.next;
            }
            node = node.next;
        }

        leftNode.next = right.next;

        return left.next;
    }
}
