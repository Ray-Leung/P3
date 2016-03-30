/**
 * Created by Administrator on 2016/1/5.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean eChecked = false, numAfterE = true, dotCheck = false, numCheck = false;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                numCheck = true;
                numAfterE = true;
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (i != 0 && chars[i-1] != 'e' ) {
                    return false;
                }
            }else if (chars[i] == 'e') {
                    if (eChecked || !numCheck) {
                        return false;
                    }
                    else {
                        eChecked = true;
                        numAfterE = false;
                    }
                } else if (chars[i] == '.') {
                    if (eChecked || dotCheck) {
                        return false;
                    } else {
                        dotCheck = true;

                    }
                } else {
                    return false;
                }
            }
        return numCheck && numAfterE;
    }

    public static void main(String[] args) {
        String s = "e9";
        boolean flag = new ValidNumber().isNumber(s);
    }
}
