package leetcode;
//最大同值路径
public class Q657 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

        static int max = 0;
        public int longestUnivaluePath(TreeNode root) {
            if (root == null) return 0;
            max = 0;
            iterator(root);
            return max;
        }

        public static int iterator(TreeNode root){

            int left = 0;
            int right = 0;

            if (root.left != null && root.val == root.left.val)
                left = 1 + iterator(root.left);
            else if (root.left != null)
                iterator(root.left);

            if (root.right != null && root.val == root.right.val)
                right = 1 + iterator(root.right);
            else if (root.right!=null)
                iterator(root.right);

            if (left + right > max) max = left + right;

            return left > right ? left:right;

        }


}
