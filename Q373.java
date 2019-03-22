package leetcode;
//查找和最小的K对数字
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Q373 {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0) return result;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]+o1[1] > o2[0]+o2[1] ? 1 : (o1[0]+o1[1] == o2[0]+o2[1] ? 0 : -1);
            }
        });
        for(int i=0 ; i<nums1.length ; i++) {
            for(int j=0 ; j<nums2.length ; j++) {
                int[] tmp = new int[2];
                tmp[0] = nums1[i];
                tmp[1] = nums2[j];
                pq.add(tmp);
            }
        }
        for(int i=0 ; i<k ; i++) {
            if(pq.peek()==null) break;
            result.add(pq.poll());
        }
        return result;

    }

}
