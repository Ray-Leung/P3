/**
 * Created by Administrator on 2015/12/8.
 */
public class SearchInsertP {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        int i = new SearchInsertP().searchInsert(nums, 2);
    }
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int l = 0;
        int r = nums.length - 1;

        if (r == l) {
            if (nums[l] == target) return l;
            if (nums[l] > target) return l;
            if (nums[l] < target) return l + 1;
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                res = mid;
                break;

            } else if (mid > 0 && nums[mid] > target && nums[mid - 1] < target) {
                res = mid;
                break;

            } else if (mid < nums.length - 1 && nums[mid] < target && nums[mid + 1] > target) {
                res = mid + 1;
                break;

            } else if (mid == nums.length - 1 && nums[mid] < target) {
                res = mid + 1;
                break;

            } else if (mid == 0 && nums[mid] > target) {
                res = mid;
                break;
            } else if (nums[mid] > target) {
                r = mid - 1;

            } else {
                l = mid + 1;

            }
        }
        return res;
    }
}
