import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/21.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);

        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + (1<<i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new GrayCode().grayCode(6);
        int i = 8 >> 3;
    }
}
