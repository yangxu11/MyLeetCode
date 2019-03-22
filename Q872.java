package leetcode;

import java.util.ArrayList;
import java.util.List;
//叶值序列相同的树
public class Q872 {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        getLeaf(root1,list1);
        getLeaf(root2,list2);
        if(list1.size() != list2.size()) return false;
        for(int i=0 ; i<list1.size() ; i++){
            if(list1.get(i) != list2.get(i)) return false;
        }
        return true;
    }
    public void getLeaf(TreeNode root,List<Integer> list){
        if(root == null) return;
        //List<Integer> res = new ArrayList<>();
        if(root.left==null && root.right == null){
            list.add(root.val);
        }
        getLeaf(root.left,list);
        getLeaf(root.right,list);
    }
}
