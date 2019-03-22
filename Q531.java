package leetcode;

import java.util.ArrayList;
import java.util.List;
//树左下角的值  与（树右视图）和（在每个树行中找最大值）解法相同，
// dfs时加一个list存储每层一个值，
// 先遍历左节点，list中就为右视图
//先遍历右节点就为左视图
public class Q531 {
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        left(root,list,1);
        return list.get(list.size()-1);
    }
    public void left(TreeNode root,List<Integer> list,int level) {
        if(root==null) return;
        if(list.size()<level) {
            list.add(root.val);
        } else {
            list.set(level-1,root.val);
        }
        left(root.right,list,level+1);
        left(root.left,list,level+1);
    }
}
