package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144 {

//递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }
    public void preorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }

   //非递归
   public List<Integer> preorderTraversal1(TreeNode root) {
       List<Integer> res = new ArrayList<>();
       Stack<TreeNode> stack = new Stack<>();
       //stack.push(root);
       while(!stack.isEmpty() || root!=null){
           while(root!=null){
               stack.push(root);
               res.add(root.val);
               root = root.left;
           }
           if(!stack.isEmpty()){
               root = stack.pop();
               root = root.right;
           }
       }
       return res;
   }

}
