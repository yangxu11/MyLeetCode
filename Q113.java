package leetcode;

import java.util.ArrayList;
import java.util.List;
//路径总和2 列出各个路径
public class Q113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        getPath(list,root,sum,new ArrayList<Integer>());
        return list;
    }

    public void getPath(List<List<Integer>> list,TreeNode root,int sum,List<Integer> path) {
        if(root==null) return;

        sum -= root.val;
        path.add(root.val);

        if(root.left==null && root.right==null && sum==0) {
            list.add(new ArrayList<>(path));
        }
        getPath(list,root.left,sum,path);
        getPath(list,root.right,sum,path);

        path.remove(path.size()-1);
    }
}
