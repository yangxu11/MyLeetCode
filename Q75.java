package leetcode;
//颜色分类
public class Q75 {
    //双指针，前后并进，符合条件调换
    public void sortColors(int[] nums) {
        int red=0;
        int blue=nums.length-1;
        for(int i=0;i<=blue;i++){//注意i<=blue
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[red];
                nums[red]=temp;

                red++;
            }
            else if(nums[i]==2){
                int temp=nums[blue];
                nums[blue]=nums[i];
                nums[i]=temp;
                //此处的i--是为了防止换过来的还是2而被忽略
                i--;
                blue--;
            }
        }
    }
}
