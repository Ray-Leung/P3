import java.util.LinkedList;

/**
 * Created by Administrator on 2015/12/26.
 */
public class permutationSequence {
    public String getPermutation(int n, int k) {
    int[] numPer = {1,2,6,24,120,720,5040,40320};
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
        list.add(i);
    }
    char[] res = new char[n];

    for (int i = n - 2; i >= 0; i--) {
        int num = (k - 1) / numPer[i];
        res[n - 2 - i] = (char) (list.get(num) + '0');
        list.remove(num);
        k = k % numPer[i] == 0 ?  numPer[i] : k % numPer[i];
    }
    res[n - 1] = (char)(list.get(0) + '0');
    return new String(res);
    }

    public static void main(String[] args) {
        String res = new permutationSequence().getPermutation(9, 10);
    }
}
