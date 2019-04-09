package leetcode;

import java.util.Stack;

//二叉搜索树中的第K小的节点值
public class Q230 {

    private int index;
    //中序遍历
    public int kthSmallest(TreeNode root, int k) {
        int res = 0;
        if (root == null) {
            return res;
        }
        res = kthSmallest(root.left, k);
        if (index == k) {
            return res;
        }
        if (++index == k) {
            return root.val;
        }
        return kthSmallest(root.right, k);
    }

    //非递归
    public int kthSmallest2(TreeNode root, int k) {
        if(root==null) return 0;

        Stack<TreeNode> stack = new Stack<>();

        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k==0) return root.val;
            root = root.right;
        }
        return 0;
    }
}
