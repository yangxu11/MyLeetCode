package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 链表随机节点
 *
 * @author yx
 * @create 2019-05-01  10:47
 **/
public class Q382 {
    class Solution {
        List<ListNode> list;
        Random rand;

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.list = new ArrayList<>();
            this.rand = new Random();
            while(head!=null){
                list.add(head);
                head = head.next;
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            return list.get(rand.nextInt(list.size())).val;
        }
    }
}
