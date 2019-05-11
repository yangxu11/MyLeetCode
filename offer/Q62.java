package leetcode.offer;

import java.util.Stack;

/**
 * 二叉搜索树的第K个节点
 *
 * @author yx
 * @create 2019-05-11  11:45
 **/
public class Q62 {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = pRoot;
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                if(--k == 0) return root;
                root = root.right;
            }
        }
        return null;
    }
}
