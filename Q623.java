package leetcode;

import java.util.*;

//在二叉树中添加一行
public class Q623 {

    public static void main(String[] args) {
        Q623 q = new Q623();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
//        Set<TreeNode> set = new HashSet<>();
//        set.add(root.left);
//        set.add(root.right);
//        System.out.println(root.left.hashCode());
//        System.out.println(root.right.hashCode());
        Q102 q2 = new Q102();
        System.out.println(q2.levelOrder(q.addOneRow(root,1,4)));
        boolean s = true && true;
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null) return new TreeNode(v);
        if(d==1) {
            TreeNode nowRoot = new TreeNode(v);
            nowRoot.left = root;
            return nowRoot;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        TreeNode currentNode;
        Map<Integer,Integer> map = new HashMap<>();
        int level = 1;
        int num = 1;
        int now = 0;
        map.put(level,num);
        while(!queue.isEmpty()) {
            currentNode = queue.poll();
            now++;
            if(d-1 == level) {
                TreeNode oldLeft = currentNode.left;
                TreeNode oldRight = currentNode.right;
                currentNode.left = new TreeNode(v);
                currentNode.right = new TreeNode(v);
                currentNode.left.left = oldLeft;
                currentNode.right.right = oldRight;
            }
            if(currentNode.left != null) {
                queue.add(currentNode.left);
                if(map.containsKey(level+1)) {
                    map.put(level+1,map.get(level+1)+1);
                } else {
                    map.put(level+1,1);
                }
            }
            if(currentNode.right != null) {
                queue.add(currentNode.right);
                if(map.containsKey(level+1)) {
                    map.put(level+1,map.get(level+1)+1);
                } else {
                    map.put(level+1,1);
                }
            }
            if(now == map.get(level)) {
                now = 0;
                level++;
                if(level>=d) {break;}
            }
        }
        if(level<d) {
            TreeNode nowRoot = new TreeNode(v);
            nowRoot.left = root;
            return nowRoot;
        }

        return root;

    }

}
