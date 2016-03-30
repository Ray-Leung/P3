/**
 * Created by Administrator on 2015/12/4.
 */
public class SearchInReverseSortedArray {
    public static void main(String[] args) {
        int[] nums = {9, 1, 3, 5, 7};
        new SearchInReverseSortedArray().search(nums, 0);
    }
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int slow = 0;
        int fast = nums.length - 1;

        if (fast < 2) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }

        while (slow <= fast) {
            int mid = (slow + fast) / 2;
            if (target == nums[mid]) return mid;

            if (nums[mid] < nums[fast]) {
                if (target > nums[mid] && target <= nums[fast]) {
                    slow = mid + 1;
                } else {
                    fast = mid - 1;
                }
            } else {
                if (target >= nums[slow] && target < nums[mid]) {
                    fast = mid - 1;
                } else {
                    slow = mid + 1;
                }

            }
        }
        return -1;
    }
}
