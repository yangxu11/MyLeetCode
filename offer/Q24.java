package leetcode.offer;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 *
 * @author yx
 * @create 2019-05-05  15:49
 **/
public class Q24 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        getPath(root,target,new ArrayList<>(),0);
        return res;
    }
    public void getPath(TreeNode root,int target,ArrayList<Integer> list,int sum){
        if(root==null) return;
        list.add(root.val);
        sum += root.val;
        if(root.left==null && root.right==null && sum==target){
            res.add(new ArrayList<>(list));
        }
        getPath(root.left,target,list,sum);
        getPath(root.right,target,list,sum);
        list.remove(list.size()-1);
        sum -= root.val;
    }
}
