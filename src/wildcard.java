/**
 * Created by Administrator on 2015/12/22.
 */
public class wildcard {
    public boolean isMatch(String s, String p) {
        int saved_p = -1, saved_s = -1;
        int lp = p.length();
        int i = 0, j = 0;

        while (i < s.length()) {
            if (j < lp && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if (j < lp && p.charAt(j) == '*') {
                saved_p = j;
                saved_s = i;
                j++;
            } else if (saved_p != -1) {
                j = saved_p;
                i = saved_s;
                i++;
            } else {
                return false;
            }
        }
        for (;j < lp; j++) {
            if (p.charAt(j) != '*')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new wildcard().isMatch("aabjaojao", "a*b*j*");
    }
}
