package leetcode;
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
}
