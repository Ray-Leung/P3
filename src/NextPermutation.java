/**
 * Created by Administrator on 2015/12/1.
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        new NextPermutation().nextPermutation(nums);
        System.out.println(nums);
    }
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int cur = 0;
        int pre = 0;
        int len = nums.length - 1;

        for (int i = len - 1; i >= 0; i--)

            if (nums[i] < nums[i+1]) {
                cur = i;
                break;
            }
        for (int i = len; i > cur; i-- ) {
            if (nums[i] > nums[cur]) {
                pre = i;
                break;
            }
        }

        if (cur == 0 && pre == 0) {
            while (cur < len) {
                int tmp = nums[len];
                nums[len] = nums[cur];
                nums[len] = tmp;
                cur++;
                len--;
            }
            return;
        } else {
            int tmp = nums[cur];
            nums[cur] = nums[pre];
            nums[pre] = tmp;
            if (cur < len){
                cur++;
                while (len > cur) {
                    tmp = nums[len];
                    nums[len] = nums[cur];
                    nums[cur] = tmp;
                    cur++;
                    len--;
                }


            }
        }
    }
}
