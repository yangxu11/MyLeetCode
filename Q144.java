package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144 {

     static class TreeNode {
         int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(node!=null) {
            stack.push(node);
            list.add(node.val);
            node = node.left;
            while(node == null) {
                if(stack.isEmpty()) {
                    break;
                }
                node = stack.pop().right;
            }
        }

        return list;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        System.out.println(preorderTraversal(root));
    }
}
