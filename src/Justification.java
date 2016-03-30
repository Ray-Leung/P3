import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/12.
 */
public class Justification {
    private List<String> res;
    public List<String> fullJustify(String[] words, int maxWidth) {
        res = new ArrayList<>();
        if (words == null || words.length == 0 || maxWidth < 0) return res;
        if (maxWidth == 0) {
            res.add("");
            return res;
        }
        helper(words, 0, maxWidth);
        return res;
    }

    private void helper(String[] words, int start, int max) {
        if (start >= words.length) {
            return;
        }

        int i = start, len = 0, total = 0, next = -1;
        while (total < max && i < words.length) {
            total += words[i].length();
            if (total > max) {
                next = i;
                break;
            }
            len += words[i].length();
            total++;
            i++;
        }
        if (next == -1) next = i;
        add(words, start, next, len, max);
        helper(words, next, max);
    }

    private void add(String[] words, int start, int end, int len,int max) {
        StringBuilder sb = new StringBuilder();
        int count = end - start - 1, space = 0, s = 0, more = 0;

        if (count == 0 || end == words.length) {
            for (int i = start; i < end; i++) {
                sb.append(words[i]);
                if (i == end - 1) break;
                sb.append(" ");
            }
            space = max - sb.length();
            s = 0;
            while (s++ < space) {
                sb.append(" ");
            }
        } else {
            space = (max - len) / count;
            more = (max - len) % count;

            for (int i = start; i < end; i++) {
                sb.append(words[i]);
                s = 0;
                if (i == end - 1) break;

                while (s++ < space) {
                    sb.append(" ");
                }
                if (more-- > 0) sb.append(" ");
            }
        }
        res.add(sb.toString());
    }

    public static void main(String[] args) {
        String[] strs = {"a","b","c","d","e"};
        int i = 3;
        List<String> res = new Justification().fullJustify(strs, i);
    }
}
