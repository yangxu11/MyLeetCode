package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//对称二叉树
public class Q101 {
    //递归
    public boolean isSymmetric1(TreeNode root) {
        if(root==null) return true;
        return isSame(root.left,root.right);
    }
    public boolean isSame(TreeNode left,TreeNode right){
        if(left==null && right==null) return true;
        if(left!=null && right==null) return false;
        if(left==null && right!=null) return false;
        if(left.val != right.val) return false;
        return isSame(left.right,right.left) && isSame(left.left,right.right);
    }

    //非递归
    //层序遍历，如果翻转和现在相同，为true
    public boolean isSymmetric2(TreeNode root) {
        if(root==null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0 ; i<size ; i++) {
                TreeNode now = queue.pop();
                if(now.left!=null) {
                    queue.add(now.left);
                    list.add(now.left.val);
                } else {
                    list.add(null);
                }
                if(now.right!=null) {
                    queue.add(now.right);
                    list.add(now.right.val);
                } else {
                    list.add(null);
                }
            }
            List<Integer> newList = new ArrayList<>(list);
            Collections.reverse(list);
            if(!list.equals(newList)) return false;
        }
        return true;
    }

}
