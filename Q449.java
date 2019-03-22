package leetcode;

import java.util.LinkedList;

public class Q449 {
    public TreeNode makeTree(String[] vals) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(vals[0]=="#")
        {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));

        stack.add(root);
        for(int i=1 ; i<vals.length ; i++) {
            if(vals[i]!="#") {
                int val = Integer.parseInt(vals[i]);
                TreeNode node = new TreeNode(val);
                TreeNode current = stack.peek();
                if(val<current.val) {
                    current.left=node;
                    stack.add(node);
                    break;
                } else {
                    while(true) {
                        current = stack.pop();
                        if (stack.isEmpty()) {
                            current.right = node;
                            stack.add(current);
                            break;
                        } else {
                            TreeNode next = stack.peek();
                            if (next.val > val) {
                                current.right = node;
                                stack.add(node);
                                break;
                            }
                        }
                    }
                }


            }
        }
return root;
    }
}
