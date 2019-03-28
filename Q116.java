package leetcode;

import java.util.LinkedList;
import java.util.Queue;

//填充同一层兄弟节点
public class Q116 {
    class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
  //递归
    public void connect(TreeLinkNode root) {
        if(root==null) return;

        if(root.left!=null) {
            root.left.next = root.right;
        } else {
            return;
        }
        TreeLinkNode leftnode = root.left;
        TreeLinkNode rightnode = root.right;
        while(leftnode.left!=null) {
            leftnode.right.next = rightnode.left;
            leftnode = leftnode.right;
            rightnode = rightnode.left;
        }
        connect(root.left);
        connect(root.right);
    }

    //层序遍历
    public TreeLinkNode connect2(TreeLinkNode root) {
        if(root==null) return null;

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0 ; i<size ; i++){
                TreeLinkNode node = queue.poll();
                if(i<size-1){
                    node.next = queue.peek();
                }
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }
        return root;
    }
}
