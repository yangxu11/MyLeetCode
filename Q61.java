package leetcode;
//旋转链表
public class Q61 {
    //先找到链表总长度，k%len, 然后解法类似Q19（删除倒数第N个节点），双指针
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0) return head;
        int len = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = head;
        while(node!=null){
            node = node.next;
            len++;
        }
        if(len<=1) return head;
        k = k%len;
        if(k==0) return head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(k>0){
            fast = fast.next;
            k--;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        dummy.next = slow.next;
        slow.next = null;
        fast.next = head;
        return dummy.next;
    }
}
