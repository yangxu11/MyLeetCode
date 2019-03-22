package leetcode;
//有序链表转化为二叉搜索树
public class Q109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;

        if(head.next==null) return new TreeNode(head.val);
        ListNode pre = findMid(head);
        ListNode mid = pre.next;
        pre.next=null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    public ListNode findMid(ListNode head) {
        if(head==null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode pre = head;

        while(fast!=null && fast.next!=null) {
            pre= slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return pre;
    }
}
