public class LookAndSay {
    private static String sayIt(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0, right = 0;
        while (right < s.length()) {
            int k = 0;
            while (right < s.length() && s.charAt(left) == s.charAt(right)) {
                k++;
                right++;
            }
            sb.append(k).append(s.charAt(left));
            left = right;
        }
        return sb.toString();
    }

    public static String countAndSay(int n) {
        String s = "1";
        if (n == 1) return s;
        for (int i = 0; i < n-1; i++) {
            s = sayIt(s);
        }
        return s;
    }
//    countAndSay(1) = "1"
//    countAndSay(2) = say "1" = one 1 = "11"
//    countAndSay(3) = say "11" = two 1's = "21"
//    countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
    public static void main(String[] args) {
        System.out.println(countAndSay(16));
    }
}
