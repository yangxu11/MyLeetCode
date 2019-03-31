package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 链表中下一个更大的节点
 *
 * @author yx
 * @create 2019-03-31  21:31
 **/
public class Q1030 {
    //栈
    public int[] nextLargerNodes(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<>();
        int count=0;
        ListNode node = head;
        while(node!=null){
            map.put(node,count);
            node = node.next;
            count++;
        }
        if(count==0) return new int[0];
        int[] res = new int[count];

        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        head = head.next;
        while(head!=null){
            while(!stack.isEmpty()&&head.val>stack.peek().val){
                ListNode cur = stack.pop();
                res[map.get(cur)] = head.val;
            }
            stack.push(head);
            head = head.next;
        }
        while(!stack.isEmpty()){
            res[map.get(stack.pop())] = 0;
        }


        return res;
    }
}
