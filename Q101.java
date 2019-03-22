package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//对称二叉树
public class Q101 {
    public boolean isSymmetric(TreeNode root) {
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
