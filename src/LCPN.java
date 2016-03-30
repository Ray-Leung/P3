/**
 * Created by Administrator on 2015/11/19.
 */
import java.util.*;
public class LCPN {
    List<String> list = new ArrayList<>();
    HashMap<Character, char[]> map = new HashMap();
    public static void main(String[] args) {
        new LCPN().letterCombinations("");
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return list;
        char[] c2 = {'a', 'b', 'c'}; map.put('2', c2);
        char[] c3 = {'d', 'e', 'f'}; map.put('3', c3);
        char[] c4 = {'g', 'h' ,'i'}; map.put('4', c4);
        char[] c5 = {'j', 'k', 'l'}; map.put('5', c5);
        char[] c6 = {'m', 'n', 'o'}; map.put('6', c6);
        char[] c7 = {'p', 'q', 'r','s'}; map.put('7', c7);
        char[] c8 = {'t', 'u', 'v'}; map.put('8', c8);
        char[] c9 = {'w', 'x', 'y', 'z'}; map.put('9', c9);
        toStr(0, digits, "");
        return list;
    }
    public void toStr(int i, String digits, String str){
        if (i == digits.length()) {
            list.add(str);
            return;
        }
        if(digits.charAt(i) == '1' || digits.charAt(i) == '0') {
            list.clear();
            return;
        }
        char[] temp = map.get(digits.charAt(i));
        for (char tmp : temp) {
            str += tmp;
            toStr(i+1, digits, str);
            str = str.substring(0, str.length()-1);
        }
        return;
    }
}
