/**
 * Created by Administrator on 2015/12/15.
 */
public class FMI {
    public static void main(String[] args) {
        int[] nums = {2, 1};
        new FMI().firstMissingPositive(nums);
    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0 || nums == null) return 1;

        int len = nums.length;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i]-1] != nums[i]) {
                int tmp = nums[i];
                int j = nums[i] - 1;
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
