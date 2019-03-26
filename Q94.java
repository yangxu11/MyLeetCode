package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 *
 * @author yx
 * @create 2019-03-26  10:01
 **/
public class Q94 {
   //递归
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal1(TreeNode root) {
        inorder(root);
        return res;
    }
    public void inorder(TreeNode root){
        if(root == null) {
            return;
        }
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }

    //非递归 栈
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    //非递归  O(1)空间
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode p=root,tmp;
        while(p!=null){
            if(p.left==null){
                res.add(p.val);
                p = p.right;
            } else{
                tmp = p.left;
                while(tmp.right!=null && tmp.right!=p){
                    tmp = tmp.right;
                }
                if(tmp.right==null){
                    tmp.right = p;
                    p = p.left;
                } else{
                    res.add(p.val);
                    p = p.right;
                    tmp.right=null;
                }
            }
        }
        return res;
    }
}
