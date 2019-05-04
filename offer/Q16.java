package leetcode.offer;

/**
 * 合并两个排序链表
 *
 * @author yx
 * @create 2019-05-04  10:12
 **/
public class Q16 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode ans = res;

        while(list1!=null && list2!=null){
            if(list1.val > list2.val){
                res.next = new ListNode(list2.val);
                list2 = list2.next;
            } else{
                res.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            res = res.next;
        }
        if(list1!=null){
            res.next = list1;
        }
        if(list2!=null){
            res.next = list2;
        }
        return ans.next;
    }
}
