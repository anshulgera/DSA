public class Solution {
    public String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public String intToRoman(int A) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (A > 0) {
            if (A-values[i] >= 0) {
                sb.append(symbols[i]);
                A -= values[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
