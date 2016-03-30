import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Administrator on 2015/11/18.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        new ThreeSum().threeSum(nums);
    }
    public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> listf = new ArrayList<List<Integer>>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if(i> 0 && nums[i] == nums[i-1]) continue;
                int target = 0 - nums[i];
                int j = i + 1;
                int k = nums.length-1;
                while (j < k) {
                    if (nums[j] + nums[k] == target) {
                        listf.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j+1]) j++;
                        while (j < k && nums[k] == nums[k-1]) k--;
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] < target) j++;
                    else k--;
                }
            }
            return listf;
        }
    }