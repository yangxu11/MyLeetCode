package leetcode;
//将有序数组转换为二叉搜索树
public class Q108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return build(nums,0,nums.length-1);

    }

    public TreeNode build(int[] nums,int l,int r) {
        if(l>r) return null;
        if(l==r) return new TreeNode(nums[l]);


        int mid = (l+r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums,l,mid-1);
        root.right = build(nums,mid+1,r);

        return root;

    }
}
