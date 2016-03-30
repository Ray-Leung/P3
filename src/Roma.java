/**
 * Created by Administrator on 2015/11/17.
 */
public class Roma {
    public static void main(String[] args) {
        String r = new Roma().intToRoman(3999);
    }
    public enum Romans {
        M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);
        private final int value;
        Romans(int value) {
            this.value = value;
        }
    }
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (Romans romans : Romans.values()) {
            while (num >= romans.value) {
                sb.append(romans);
                num -= romans.value;
            }
        }
        return sb.toString();
    }
}
