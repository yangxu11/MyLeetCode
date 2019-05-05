package leetcode.offer;

import java.util.Stack;

/**
 * 二叉树与双向链表
 *
 * @author yx
 * @create 2019-05-05  16:25
 **/
public class Q26 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;
        TreeNode head = new TreeNode(0);
        TreeNode dummy = head;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = pRootOfTree;
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                root = node.right;
                head.right = node;
                node.left = head;
                head = head.right;
            }
        }
        dummy.right.left = null;
        return dummy.right;
    }
}
