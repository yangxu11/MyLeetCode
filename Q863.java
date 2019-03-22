package leetcode;

import java.util.*;
//二叉树中所有距离为 K 的结点
public class Q863 {

    //将每个节点的高度存入map，遍历，使用两个节点的最小公共祖先来查两个节点的距离
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> list = new ArrayList<>();
        Map<TreeNode,Integer> map = new HashMap<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count=0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for(int i=0;i<size ; i++) {
                TreeNode node = queue.pop();
                map.put(node,count);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        for(TreeNode node : map.keySet()) {
            TreeNode f= lowestCommonAncestor(root,node,target);
            int x = map.get(node)-map.get(f);
            int y = map.get(target)-map.get(f);
            if( x+y ==K) {
                list.add(node.val);
            }
        }
        return list;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==q || root==p) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) {
            return root;
        }
        return left!=null ? left : right;
    }


}
