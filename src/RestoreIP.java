import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/28.
 */
public class RestoreIP {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0 || s == "") return res;

        dfs (res, 0, "", s);
        return res;
    }

    public void dfs(List<String> res, int count, String tmp, String s) {
        if (count == 4) {
            res.add(tmp.substring(0, tmp.length() - 1));
        } else {
            for (int i = 0; i < 3; i++) {
                if (s.length() - i - 1 < 3 - count || s.length() - i - 1 > (3 - count) * 3) continue;
                if (i > 0 && s.charAt(0) == '0') break;
                if (i == 2 && s.substring(0, 3).compareTo("255") > 0) break;
                dfs(res, count + 1, tmp + s.substring(0, i+1) +".", s.substring(i + 1));
            }
        }

    }

    public static void main(String[] args) {
        List<String> res = new RestoreIP().restoreIpAddresses("11112");

    }
}
