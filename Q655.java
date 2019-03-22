package leetcode;

import java.util.*;

public class Q655 {

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> list = new ArrayList();

        if(root == null) return list;

        int h = getHeight(root);
        int w = (int)Math.pow(2,h);

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);



        TreeNode currentNode;

        while(!queue.isEmpty()) {
            currentNode = queue.poll();

            if(currentNode.left!=null) {
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null) {
                queue.add(currentNode.right);
            }
        }

        return  list;

    }

    public static int getHeight(TreeNode root) {
        if(root == null) return 0;

        return 1+Math.max(getHeight(root.left),getHeight(root.right));

    }

}
