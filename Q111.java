package leetcode;

import java.util.LinkedList;

/**
 * 二叉树的最小深度
 *
 * @author yx
 * @create 2019-03-28  17:50
 **/
public class Q111 {

    //遇到比较左子树和右子树的情形，先递归的到左右子树的信息，再做比较返回
    //递归
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left > 0 && right>0){
            return Math.min(left,right) +1 ;
        }else{
            return 1+left + right;
        }
    }
    /**
     * @Author YX
     * @Description  非递归
     * @Date 17:51 2019/3/28
     * @Param [root]
     * @return int
     **/
    public int minDepth2(TreeNode root) {
        int result=0;
        if(root==null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            result++;
            int size = queue.size();

            for(int i=0 ; i<size ; i++) {
                TreeNode cur = queue.pop();
                if(cur.left==null && cur.right==null) {
                    return result;
                }
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
        }
        return result;
    }
}
