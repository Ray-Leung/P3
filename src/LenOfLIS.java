/**
 * Created by Administrator on 2015/12/25.
 */
public class LenOfLIS {
    public int lengthOfLIS(int[] nums) {
    int r = nums.length - 1;
    int max = 0;
    int[] ns = new int [r + 1];
    for (int n : nums) {
        int j = BinarySearch(ns, 0, max-1, n);
        ns[j] = n;
        if (j == max) max++;
    }
    return max;
}

    private int BinarySearch(int[] nums, int l, int r, int key) {
        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] < key) {
                l  = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = new LenOfLIS().lengthOfLIS(nums);
    }
}
