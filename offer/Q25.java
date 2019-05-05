package leetcode.offer;

import java.util.HashMap;

/**
 * 复杂链表的复制
 *
 * @author yx
 * @create 2019-05-05  15:50
 **/
public class Q25 {
    HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null) return null;
        RandomListNode root = new RandomListNode(pHead.label);
        map.put(pHead,root);
        if(map.containsKey(pHead.next)){
            root.next = map.get(pHead.next);
        } else{
            root.next = Clone(pHead.next);
        }
        if(map.containsKey(pHead.random)){
            root.random = map.get(pHead.random);
        } else{
            root.random = Clone(pHead.random);
        }
        return root;
    }


    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
