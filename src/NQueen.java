/**
 * Created by Administrator on 2015/12/24.
 */
import java.util.*;
public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0)
            return new ArrayList<List<String>>();
        List<List<String>> res = new ArrayList<>();

        dfs(new int[n], 0, n, res);
        return res;
    }

    public void dfs(int[] pos, int step, int n, List<List<String>> res) {
        if (step == n) {
            List<String> list = printboard(pos, n);
            res.add(new ArrayList<String>(list));
            return;
        } else {
            for (int i = 0; i < n; i++) {
                pos[step] = i;
                if (isValid(pos, step)) {
                    dfs(pos, step+1, n, res);
                }
            }
        }
    }
    private boolean isValid(int[]pos, int step) {
        for (int i = 0; i < step; i++) {
            if (pos[i] == pos[step] || (Math.abs(pos[i] - pos[step])) == (step - i)) return false;
        }
        return true;
    }

    private List<String> printboard(int[] pos, int n) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n - 1; j++) sb.append('.');

            sb.insert(pos[i], "Q");
            list.add(sb.toString());
        }
        return list;
    }
    public static void main(String[] args) {
        List<List<String>> res = new NQueen().solveNQueens(4);
        int i = 0;
    }
}
