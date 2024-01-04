import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int colorful(int num) {
        Set set = new HashSet<>();
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            long x = 1;
            for (int j = i; j < s.length(); j++) {
                int n = s.charAt(j) - '0';
                x *= n;
                if (set.contains(x)) {
                    return 0;
                }
                set.add(x);
            }
        }
        return 1;
    }
}