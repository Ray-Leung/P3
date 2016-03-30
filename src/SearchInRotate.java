/**
 * Created by Administrator on 2016/3/10.
 */
public class SearchInRotate {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) return true;

            if (nums[mid] == nums[l]) {
                l++;

            } else if (nums[mid] < nums[r]) {
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (nums[mid] <= target && nums[l] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 1};
        boolean res = new SearchInRotate().search(nums, 3);
    }
}
