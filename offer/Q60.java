package leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 二叉树层序遍历
 *
 * @author yx
 * @create 2019-05-10  17:32
 **/
public class Q60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        if(pRoot==null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0 ; i<size ; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
