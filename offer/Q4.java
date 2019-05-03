package leetcode.offer;

/**
 * 重建二叉树
 *
 * @author yx
 * @create 2019-05-03  11:31
 **/
public class Q4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return getTree(pre,in,0,pre.length-1,0,in.length-1);
    }
    public TreeNode getTree(int[] pre,int[] in,int pleft,int pright,int ileft,int iright){
        if(pleft>pright){
            return null;
        }
        if(pleft == pright){
            return new TreeNode(pre[pleft]);
        }
        int index = ileft;
        for(int i=ileft;i<=iright ; i++){
            if(in[i] == pre[pleft]){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(pre[pleft]);
        root.left = getTree(pre,in,pleft+1,pleft+index-ileft,ileft,index-1);
        root.right = getTree(pre,in,pleft+index-ileft+1,pright,index+1,iright);
        return root;
    }
}
