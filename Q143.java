package leetcode;

import java.util.LinkedList;

/**
 * 重排链表
 *
 * @author yx
 * @create 2019-03-31  21:46
 **/
public class Q143 {
    //双端队列
    //queue.pollFirst()头部出队(poll())  queue.pollLast()队尾出队
    public void reorderList(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            queue.addLast(cur);
            cur = cur.next;
        }
        while (!queue.isEmpty()) {
            if (cur == null) {
                cur = queue.pollFirst();
            } else {
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            cur.next = queue.pollLast();
            cur = cur.next;
        }
        if (cur != null) {
            cur.next = null;
        }
    }
}
