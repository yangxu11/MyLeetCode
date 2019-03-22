package leetcode;
//合并两个有序数组
public class Q88 {
    //5ms 67%  从头合并
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
    //5ms  从后合并
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        while(m>0&&n>0){
            nums1[index] = nums1[m-1] >= nums2[n-1] ? nums1[m-1] : nums2[n-1];
            index--;
            if(nums1[m-1] >= nums2[n-1]){
                m--;
            } else {
                n--;
            }
        }
        while(m>0){
            nums1[index] = nums1[m-1];
            m--;
            index--;
        }
        while(n>0){
            nums1[index] = nums2[n-1];
            n--;
            index--;
        }

    }
}
