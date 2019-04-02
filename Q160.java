package leetcode;

/**
 * 相交链表
 *
 * @author yx
 * @create 2019-04-02  18:10
 **/
public class Q160 {
    //当一条链到头接到另一条链，当两个链节点相同时，相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode pA = headA,pB = headB;
        while(pA!=pB){
            pA = pA==null ? headB : pA.next;
            pB = pB==null ? headA : pB.next;
        }
        return pA;
    }
}
