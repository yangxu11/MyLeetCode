package leetcode;

import java.util.Stack;

/**
 * 两数相加
 *
 * @author yx
 * @create 2019-05-21  20:28
 **/
public class Q445 {
//使用栈
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while(l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int num = 0;
        ListNode res = new ListNode(0);
        ListNode node = res;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int tmp = x + y + num;
            node.next = new ListNode(tmp%10);
            num = tmp/10;
            node = node.next;
        }
        if(num>0) node.next = new ListNode(1);

        return reverse(res.next);

    }


    //翻转链表
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        l1 = reverse(l1);
        l2 = reverse(l2);
        int num=0;
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while(l1!=null || l2!=null){
            int x = l1==null ? 0 : l1.val;
            int y = l2==null ? 0 : l2.val;

            int tmp = x + y + num;
            res.next = new ListNode(tmp%10);
            num = tmp/10;
            res = res.next;
            l1 = l1==null ? null : l1.next;
            l2 = l2==null ? null : l2.next;
        }
        if(num>0) res.next = new ListNode(1);
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = head;
        while(head.next!=null){
            ListNode tmp = head.next;
            head.next = head.next.next;
            dummy.next = tmp;
            tmp.next = node;
            node = dummy.next;
        }
        return dummy.next;
    }
}
