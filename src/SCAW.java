import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2015/11/30.
 */
public class SCAW {
    public static void main(String[] args) {
        String[] ss = {"foo", "bar"};
        new SCAW().findSubstring("barfoothefoobarman", ss);
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || s.length() == 0) return list;

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else {
                map.put(word, 1);
            }
        }
        int len = words[0].length();
        for (int i = 0; i < len; i++) {
            HashMap<String, Integer> curMap = new HashMap<>();
            int start = i;
            int count = 0;

            for (int j = i; j <= s.length()-len; j += len) {
                String sub = s.substring(j, j+len);
                if (map.containsKey(sub)) {
                    if (curMap.containsKey(sub)) {
                        curMap.put(sub, curMap.get(sub)+1);
                    } else {
                        curMap.put(sub, 1);
                    }
                    count++;

                    while(curMap.get(sub) > map.get(sub)) {
                        String left = s.substring(start, start+len);
                        curMap.put(left, curMap.get(left)-1);
                        count--;
                        start += len;
                    }

                    if (count == words.length) {
                        list.add(start);
                        String left = s.substring(start, start+len);
                        if (curMap.containsKey(left)) {

                        curMap.put(left, curMap.get(left)-1);
                        }
                        count--;
                        start += len;
                    }
                } else {
                    curMap.clear();
                    start = j+len;
                    count = 0;
                }
            }
        }
        return list;
    }
}
