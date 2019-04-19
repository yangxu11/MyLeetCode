package leetcode;

/**
 * 区域和检索-数组可修改
 *
 * @author yx
 * @create 2019-04-19  20:25
 **/
public class Q307 {

    //线段树
    class NumArray {

        class Node {
            int l;
            int r;
            int val;
            int f;

            public Node(int l, int r) {
                this.l = l;
                this.r = r;
            }
        }

        private int[] nums;
        private Node[] tree;

        public NumArray(int[] nums) {

            if(nums.length==0) return;
            this.nums = nums;
            // 叶子节点是N,总结点数最多4*N
            tree = new Node[nums.length * 4];
            build(0, 0, nums.length - 1);

        }

        private void build(int n, int l, int r) {
            tree[n] = new Node(l, r);
            if (l == r) {
                tree[n].val = nums[l];
                return;
            }
            int mid = (l + r) / 2;
            build(2 * n + 1, l, mid);
            build(2 * n + 2, mid + 1, r);
            tree[n].val = tree[2 * n + 1].val + tree[2 * n + 2].val;
        }

        public void update(int i, int val) {
            update(0, i, val);
        }

        public int sumRange(int i, int j) {
            return sumRange(0, i, j);
        }


        private void update(int n, int i, int val)//单点修改
        {
            if (tree[n].l == tree[n].r) {
                tree[n].val = val;
                return;
            }
            int m = (tree[n].l + tree[n].r) / 2;
            if (i <= m) update(n * 2 + 1, i, val);
            else update(n * 2 + 2, i, val);
            tree[n].val = tree[n * 2 + 1].val + tree[n * 2 + 2].val;
        }

        private int sumRange(int n, int i, int j)//区间查询
        {
            if (tree[n].l >= i && tree[n].r <= j) {
                return tree[n].val;
            }
            int result = 0;
            int mid = (tree[n].l + tree[n].r) / 2;
            if (i <= mid) {
                result += sumRange(2 * n + 1, i, j);
            }
            if (j > mid) {
                result += sumRange(2 * n + 2, i, j);
            }
            return result;
        }
    }
}
