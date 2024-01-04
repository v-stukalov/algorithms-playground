public class OneEditAway {
    public static boolean isOneEditDistance(String s1, String s2) {
        if (s1.length() > s2.length()) {
            s1 = s1 + s2;
            s2 = s1.substring(0, s1.length() - s2.length());
            s1 = s1.substring(s2.length());
        }
        if ("".equals(s1))
            return s2.length() == 1;
        if (s2.length() - s1.length() > 1)
            return false;
        boolean saw_difference = false;
        for (int i = 0, j = 0; i < s1.length(); i++, j++) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (saw_difference) return false;
                saw_difference = true;
                if (s2.length() > s1.length()) {
                    i--;
                }
            }
        }
        return saw_difference || s2.length() != s1.length();
    }

    public static void main(String[] args) {
        System.out.println(isOneEditDistance("a", ""));
    }
}
