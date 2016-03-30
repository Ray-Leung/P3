/**
 * Created by Administrator on 2015/11/27.
 */
public class removeValFromArray {
    public static void main(String[] args) {
        int[] nums = {0,1,0,0,2,3,1};
        int val = 0;
        if (nums.length < 1 || nums == null) ;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        System.out.println(j);
    }
}
