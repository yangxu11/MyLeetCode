package leetcode.offer;

import java.util.ArrayList;

/**
 * 从尾到头打印链表
 *
 * @author yx
 * @create 2019-05-02  11:25
 **/
public class Q3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while(listNode!=null){
            list.add(listNode.val);
            listNode  = listNode.next;
        }
        return reverse(list);

    }
    public ArrayList<Integer> reverse(ArrayList<Integer> list){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=list.size()-1 ; i>=0 ; i--){
            res.add(list.get(i));
        }
        return res;
    }
}
