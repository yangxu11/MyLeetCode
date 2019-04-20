package leetcode;

/**
 * 区域和检索-数组可修改
 *
 * @author yx
 * @create 2019-04-19  20:25
 **/
public class Q307 {

    //线段树，构造树结构存储数组，左节点为左半数组，右节点为右半数组，更新时二分查找，取和时也是二分查找
    class NumArray {
        class Node{
            int start,end;
            int sum;
            Node left;
            Node right;
            public Node(int start,int end,int sum){
                this.start = start;
                this.end = end;
                this.sum = sum;
            }
        }

        private int[] nums;
        private Node root;

        public NumArray(int[] nums) {
            if(nums.length==0) return;
            this.nums = nums;
            root = buildTree(0,nums.length-1);
        }

        private Node buildTree(int start,int end){
            if(start==end){
                return new Node(start,end,nums[start]);
            }
            int mid = start + (end-start)/2;
            Node node = new Node(start,end,0);
            node.left = buildTree(start,mid);
            node.right = buildTree(mid+1,end);
            node.sum = node.left.sum + node.right.sum;
            return node;
        }

        public void update(int i, int val) {
            update(root,i,val);
        }
        private void update(Node root,int i,int val){
            if(root.start==root.end && root.start==i){
                root.sum = val;
                return;
            }
            int mid = root.start + (root.end - root.start) / 2;//二分查找
            if (i <= mid) {
                update(root.left,i,val);
            } else {
                update(root.right,i,val);
            }
            root.sum = root.left.sum + root.right.sum;
            return;
        }

        public int sumRange(int i, int j) {
            return sumRange(root,i,j);
        }
        private int sumRange(Node root,int i,int j){
            if(root.start==i && root.end==j){
                return root.sum;
            }

            int mid = root.start+(root.end - root.start)/2;//二分查找
            if(j<=mid) return sumRange(root.left,i,j);
            if(i>mid) return sumRange(root.right,i,j);

            return sumRange(root.left,i,mid)+sumRange(root.right,mid+1,j);

        }
    }
}
