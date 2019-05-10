package leetcode.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 之字形打印二叉树
 *
 * @author yx
 * @create 2019-05-10  17:30
 **/
public class Q59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        if(pRoot==null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int sign = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0 ; i<size ; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            if(sign > 0){
                res.add(list);
            } else{
                Collections.reverse(list);
                res.add(list);
            }
            sign *= -1;
        }
        return res;
    }
}
