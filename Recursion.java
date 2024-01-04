public class Recursion {
    public String stripZeroes(String text) {
        if (text.charAt(0) == '0') {
            return stripZeroes(text.substring(1));
        }
        return text;
    }

    public static void main(String[] args) {
        String text = "0equation";
        char[] chars = text.toCharArray();
        int length = chars.length - 1;
        for (int i = 0; i <= length / 2; i++) {
            char c = chars[i];
            chars[i] = chars[length - i];
            chars[length - i] = c;
        }
        text = String.valueOf(chars);
        System.out.println(text);
//        Recursion recursion = new Recursion();
//        System.out.println(recursion.stripZeroes("00000000167890"));
    }
}
