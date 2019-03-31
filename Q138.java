package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 *
 * @author yx
 * @create 2019-03-31  10:20
 **/
public class Q138 {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    //思路同Q133克隆图，哈希表+递归
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node next = new Node();
        Node random = new Node();
        Node node = new Node(head.val,next,random);
        map.put(head,node);
        if(map.containsKey(head.random)){
            node.random = map.get(head.random);
        }else{
            node.random = copyRandomList(head.random);
        }
        if(map.containsKey(head.next)){
            node.next = map.get(head.next);
        }else{
            node.next = copyRandomList(head.next);
        }
        return node;
    }
}
