/**
 * Created by Administrator on 2015/12/7.
 */
public class SearchForARange {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] is = new SearchForARange().searchRange(nums, 3);
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) return result;

        int len = nums.length - 1;

        if (len == 0) {
            if (nums[0] == target) {
                return new int[] {0, 0};
            } else {
                return result;
            }
        }

        if (len == 1) {
            if (nums[0] == target || nums[1] == target) {
                int i = nums[0] == target ? 0 : 1;
                int j = nums[1] == target ? 1 : 0;
                return new int[] {i,j};
            } else {
                return result;
            }
        }

        int l = 0;
        int r = len;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target && mid == 0) {
                result[0] = mid;
                break;
            } else if (mid > 0 && nums[mid] == target && nums[mid - 1] < target) {
                result[0] = mid;
                break;
            }

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        l = 0;
        r = len;
        while(l <= r) {
            int mid = (l + r) /2;

            if (mid == len && nums[mid] == target) {
                result[1] = mid;
                break;
            } else if (mid < len && nums[mid] == target && nums[mid + 1] > target) {
                result[1] = mid;
                break;
            }

            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}
