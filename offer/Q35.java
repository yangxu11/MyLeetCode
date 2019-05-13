package leetcode.offer;

/**
 * 数组中的逆序对
 *
 * @author yx
 * @create 2019-05-13  17:10
 **/
public class Q35 {
    public int InversePairs(int [] array) {
        if(array==null||array.length==0)
        {
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length-1);//数值过大求余
        return count;

    }
    private int InversePairsCore(int[] array,int[] copy,int low,int high)
    {
        if(low == high){
            return 0;
        }
        int mid = (low+high)>>1;
        int left = InversePairsCore(array,copy,low,mid)%1000000007;
        int right = InversePairsCore(array,copy,mid+1,high)%1000000007;
        int i = mid;
        int j = high;
        int count = 0;
        int pos = high;
        while(i>=low && j>mid){
            if(array[i] > array[j]){
                count += j-mid;
                if(count>=1000000007){
                    count %= 1000000007;
                }
                copy[pos--] = array[i--];
            } else{
                copy[pos--] = array[j--];
            }
        }
        while(i>=low){
            copy[pos--] = array[i--];
        }
        while(j>mid){
            copy[pos--] = array[j--];
        }
        for(int x = low ; x<=high ; x++){
            array[x] = copy[x];
        }
        return (left+right+count)%1000000007;
    }
}
