import java.util.HashMap;

/**
 * Created by Administrator on 2015/11/9.
 */
public class Lp {
    public static void main(String[] args) {
        String s = "abcdeffedcbabceecbanmdod";
        System.out.println(new Lp().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        String longest = s.substring(0,1);

        if (len < 2) return longest;

         for (int i = 0; i < len - 1; i++){
            String p1 = extendAroundCenter(s, i, i);
            String p2 = extendAroundCenter(s, i, i+1);
            String p  = p1.length() > p2.length() ? p1:p2;
             longest = p.length() > longest.length() ? p:longest;
         }
        return longest;
        }
    public String extendAroundCenter(String s, int l, int r) {
        while (l >= 0 && r <= s.length()-1 && s.charAt(l) == s.charAt(r)) {
            r++;
            l--;
        }
        try{
        return s.substring(l+1, r);
    }
        catch (StringIndexOutOfBoundsException e) {
        return s.substring(0,1);
        }
    }
}
