package leetcode;

import java.util.LinkedList;
//完全二叉树的节点个数
public class Q222 {

    //92% 层序遍历
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int count = 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            count += size;
            for(int i=0 ; i<size ; i++){
                TreeNode node = queue.pop();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return count;
    }
    //95%  递归
    public int countNodes2(TreeNode root) {
        if(root==null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
//99%  递归 + 二分
    public int countNodes3(TreeNode root) {
        /**
         完全二叉树的高度可以直接通过不断地访问左子树就可以获取
         判断左右子树的高度:
         如果相等说明左子树是满二叉树, 然后进一步判断右子树的节点数(最后一层最后出现的节点必然在右子树中)
         如果不等说明右子树是深度小于左子树的满二叉树, 然后进一步判断左子树的节点数(最后一层最后出现的节点必然在左子树中)
         **/
        if (root==null) return 0;
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        if(ld == rd) return (1 << ld) + countNodes(root.right); // 1(根节点) + (1 << ld)-1(左完全左子树节点数) + 右子树节点数量
        else return (1 << rd) + countNodes(root.left);  // 1(根节点) + (1 << rd)-1(右完全右子树节点数) + 左子树节点数量

    }

    private int getDepth(TreeNode r) {
        int depth = 0;
        while(r != null) {
            depth++;
            r = r.left;
        }
        return depth;
    }
}
