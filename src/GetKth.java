/**
 * Created by Administrator on 2015/11/8.
 */
public class GetKth {
    public static double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length) return B[bStart + k - 1];
        if (bStart > B.length) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = 0, bMid = 0;

        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid) {
            return getkth(A, aStart + k/2, B, bStart, k/2); //next right A[] element compares to left B[] elemen
        }
        else
            return getkth(A, aStart, B, bStart + k/2, k/2); //next right B[] element compares to left A[] element
    }
}
