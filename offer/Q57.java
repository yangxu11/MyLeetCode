package leetcode.offer;

import java.util.Stack;

/**
 * 二叉树的下一个节点
 *
 * @author yx
 * @create 2019-05-12  16:41
 **/
public class Q57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null) return null;
        TreeLinkNode root = getRoot(pNode);
        Stack<TreeLinkNode> stack = new Stack<>();
        TreeLinkNode pre = null;

        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                TreeLinkNode node = stack.pop();
                if(pre == pNode){
                    return node;
                }
                pre = node;
                root = node.right;
            }
        }
        return null;
    }

    public TreeLinkNode getRoot(TreeLinkNode node){
        while(node.next!=null){
            node = node.next;
        }
        return node;
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
