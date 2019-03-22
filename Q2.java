package leetcode;

public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        int up=0;
        while(l1!=null && l2!=null){
            int num = l1.val + l2.val + up;
            head.next = new ListNode(num%10);
            up =num/10;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int num = l1.val + up;
            head.next = new ListNode(num%10);
            up =num/10;
            head = head.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int num = l2.val + up;
            head.next = new ListNode(num%10);
            up =num/10;
            head = head.next;
            l2 = l2.next;
        }
        if(up==1){
            head.next = new ListNode(up);
        }
        return res.next;
    }
}
