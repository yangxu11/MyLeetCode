package leetcode;

import java.util.*;

//二叉树层次遍历
public class Q102 {

    List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        Q102 q = new Q102();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(q.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        TreeNode current;
        Map<Integer,Integer> map = new HashMap<>();
        int level = 1;
        int num = 1;
        int now = 0;
        map.put(level,num);
        List<Integer> nowList = new ArrayList<>();
        while(!queue.isEmpty()) {
            current = queue.poll();
            nowList.add(current.val);
            now++;
            if(current.left != null) {
                queue.add(current.left);
                if(map.containsKey(level+1)) {
                    map.put(level+1,map.get(level+1)+1);
                } else {
                    map.put(level+1,1);
                }
            }
            if(current.right != null) {
                queue.add(current.right);
                if(map.containsKey(level+1)) {
                    map.put(level+1,map.get(level+1)+1);
                } else {
                    map.put(level+1,1);
                }
            }
            if(now == map.get(level)) {
                now = 0;
                list.add(new ArrayList<>(nowList));
                nowList.clear();
                level++;
            }
        }

        return list;
    }

}
