package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//二叉树右视图
public class Q199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView1(root,1,result);
        return result;
    }
//dfs  递归算法
    public void rightSideView1(TreeNode root,int level,List<Integer> list) {
        if(root==null) return;

        if(list.size() <level) {
            list.add(root.val);
        } else {
            list.set(level-1,root.val);
        }

        rightSideView1(root.left,level+1,list);
        rightSideView1(root.right,level+1,list);
    }
// bfs 层序变量 非递归
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size  = queue.size();
            for(int i=0 ; i<size ; i++) {
                TreeNode node  = queue.pop();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                if(i==size-1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }
}
