package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 *
 * @author yx
 * @create 2019-04-01  17:02
 **/
public class Q145 {

    //每次遍历的结果加入末尾
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(0,node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        return res;
    }

    //每个节点入栈两遍，第一遍入栈子节点，第二遍存储自身的值，右端节点先入栈
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(!stack.isEmpty() && node == stack.peek()){
                if(node.right!=null){
                    stack.push(node.right);stack.push(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);stack.push(node.left);
                }

            } else{
                res.add(node.val);
            }
        }
        return res;
    }

    //使用一个栈专门存储节点遍历的状态，效率最差
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> mark = new Stack<>();
        int flag = 1;

        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
                mark.push(0);
            }
            while(!stack.isEmpty() && mark.peek()==flag){
                mark.pop();
                res.add(stack.pop().val);
            }
            if(!stack.isEmpty()){
                mark.pop();
                mark.push(1);
                root = stack.peek().right;
            }
        }
        return res;
    }

}
