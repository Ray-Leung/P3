/**
 * Created by Administrator on 2016/3/9.
 */
public class RemoveDArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int res = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[res-2]) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3};
        int res = new RemoveDArray().removeDuplicates(nums);
    }
}
