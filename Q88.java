package leetcode;
//合并两个有序数组
public class Q88 {
    /**5ms  从后合并**/
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int count = m+n-1;
        while(m-1>=0 || n-1>=0){
            int x = m-1>=0 ? nums1[m-1] : Integer.MIN_VALUE;
            int y = n-1>=0 ? nums2[n-1] : Integer.MIN_VALUE;
            if(x>y){
                nums1[count] = x;
                m--;
            } else{
                nums1[count] = y;
                n--;
            }
            count--;
        }
    }

    /**5ms  从头合并**/
    /**
     * @Author YX
     * @Description 
     * @Date 10:23 2019/3/26
     * @Param [nums1, m, nums2, n]
     * @return void
     **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;

        int len=0;
        while(i<m+len && j<n){
            if(nums1[i]<=nums2[j]){
                i++;
            } else {
                for(int k=m+len ; k>i ; k--){
                    nums1[k] = nums1[k-1];
                }
                nums1[i]=nums2[j];
                i++;
                j++;
                len++;
            }
        }
        while(j<n){
            nums1[i] = nums2[j];
            i++;
            j++;
        }
    }

}
