package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找到树的左下角的值
 *
 * @author yx
 * @create 2019-06-03  17:38
 **/
public class Q513 {
    //非递归
    public int findBottomLeftValue1(TreeNode root) {
        if(root==null) return 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = root.val;
        while(!queue.isEmpty()){
            int size = queue.size();
            res = queue.peek().val;
            for(int i=0 ; i<size ; i++){
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }

        return res;
    }


    //递归，维持一个记录每行第一个节点的list，最后取其最后一个值
    List<Integer> res = new ArrayList<>();
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return 0;
        dfs(root,0);
        return res.get(res.size()-1);
    }

    private void dfs(TreeNode root,int level){
        if(root==null) return;
        if(res.size()<=level){
            res.add(root.val);
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }

}
