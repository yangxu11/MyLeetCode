package leetcode;

import java.util.ArrayList;
import java.util.List;
//在每个树行中找最大值
// dfs时加一个list存储每层一个值，
public class Q515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        left(root,result,1);
        return result;
    }
    public void left(TreeNode root,List<Integer> list,int level) {
        if(root==null) return;
        if(list.size()<level) {
            list.add(root.val);
        } else {
            list.set(level-1,Math.max(root.val,list.get(level-1)));
        }
        left(root.right,list,level+1);
        left(root.left,list,level+1);
    }
}
