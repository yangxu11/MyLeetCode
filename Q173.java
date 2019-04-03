package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树迭代器
 *
 * @author yx
 * @create 2019-04-03  20:05
 **/
public class Q173 {
    class BSTIterator {

        Queue<Integer> pq = new LinkedList<>();
        public BSTIterator(TreeNode root) {
            generate(root);
        }
        private void generate(TreeNode root){
            if(root==null) {
                return;
            }
            generate(root.left);
            pq.add(root.val);
            generate(root.right);
        }

        /** @return the next smallest number */
        public int next() {
            return pq.poll();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !pq.isEmpty();
        }
    }
}
