package leetcode;
//根据前序遍历和中序遍历 还原二叉树
public class Q105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder,int l1,int r1, int[] inorder,int l2,int r2) {
        if(l1>r1) return null;
        if(l1==r1) return new TreeNode(preorder[l1]);

        TreeNode root = new TreeNode(preorder[l1]);
        int i=0;
        for( i=0 ; i<inorder.length ; i++) {
            if(inorder[i]==root.val) {
                break;
            }
        }

        root.left = build(preorder,l1+1,l1+i-l2,inorder,l2,i-1);
        root.right = build(preorder,l1+i-l2+1,r1,inorder,i+1,r2);

        return root;

    }
}
