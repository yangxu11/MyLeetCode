package leetcode;
//具有最深节点的最小子树
public class Q865 {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null) return null;
        int left = maxDeep(root.left);
        int right = maxDeep(root.right);
        if(left == right) {
            return root;
        } else if(left>right){
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }

    }
    public int maxDeep(TreeNode root) {
        if(root==null) return 0;
        int left=0;
        int right=0;
        left = maxDeep(root.left);
        right = maxDeep(root.right);
        return 1+Math.max(right,left);
    }

}
