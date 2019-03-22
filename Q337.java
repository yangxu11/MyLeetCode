package leetcode;

import java.util.HashMap;
import java.util.Map;
//打家劫舍III
public class Q337 {
    //60%  root.val与隔层的节点值相加，使用hashmap缓存已经遍历过的节点
    public int rob(TreeNode root) {
        Map<TreeNode,Integer> map = new HashMap<>();
        return getMaxValue(root,map);
    }
    public int getMaxValue(TreeNode root,Map<TreeNode,Integer> map){
        if(root==null) return 0;
        if(map.containsKey(root)) {
            return map.get(root);
        }
        int val=0;
        if(root.left!=null){
            val += getMaxValue(root.left.left,map) + getMaxValue(root.left.right,map);
        }
        if(root.right!=null){
            val += getMaxValue(root.right.left,map) + getMaxValue(root.right.right,map);
        }

        val = Math.max(val+root.val,getMaxValue(root.left,map)+getMaxValue(root.right,map));
        map.put(root,val);
        return val;
    }

    //简单递归，不使用缓存，效率低，20%
    //simple recursion without cacheing: 1189 ms
    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        val = Math.max(val + root.val, rob(root.left) + rob(root.right));
        return val;
    }
}
