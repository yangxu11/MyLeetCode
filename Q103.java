package leetcode;

import java.util.*;

/**
 * 二叉树的锯齿形层次遍历
 *
 * @author yx
 * @create 2019-03-27  20:04
 **/
public class Q103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sign = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0 ; i<size ; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            if(sign<0){
                Collections.reverse(list);
            }
            sign = -1*sign;
            res.add(list);
        }
        return res;
    }
}
