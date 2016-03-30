import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/11/4.
 */
public class P1 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,11};
        int[] b = {6,7,8,10,13,14,15};
        long st = System.currentTimeMillis();
        System.out.println(new P1().findMedianSortedArrays(a,b));
    }
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft
        else
            return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }
   /* public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int to = (m+n)/2 +1;
        int i = 0, j =0, k = 0;
        double curr = 0, prev = 0;

        while (k<to) {
            prev = curr;
            if (i != nums1.length && j != nums2.length) {
                curr = nums1[i] < nums2[j]? nums1[i++]:nums2[j++];
            }
            else if (i == nums1.length) {
                curr = nums2[j++];
            }
            else if (j == nums2.length) {
                curr = nums1[i++];
            }

            k++;
        }
        return ((m+n)%2 == 1? curr:(curr+prev)/2);
    }*/
}
