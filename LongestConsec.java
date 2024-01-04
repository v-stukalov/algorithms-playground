public class LongestConsec {
    public static String longestConsec(String[] strarr, int k) {
        if (strarr == null || strarr.length < k) return "";
        int longest = 0;
        int start = 0;
        int from = 0;

        while (start <= strarr.length - k) {
            int length = 0;
            for (int i = start; i < start + k; i++) {
                length += strarr[i].length();
            }
            if (length > longest) {
                from = start;
                longest = length;
            }
            start++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = from; i < from + k; i++) {
            sb.append(strarr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2)); //"abigailtheta"));
//        System.out.println(longestConsec(new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1)); //"oocccffuucccjjjkkkjyyyeehh");
        System.out.println(longestConsec(new String[]{}, 3)); //"");
        System.out.println(longestConsec(new String[]{"itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2)); //"wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck");
        System.out.println(longestConsec(new String[]{"wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"}, 2)); //"wlwsasphmxxowiaxujylentrklctozmymu");
        System.out.println(longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas"}, -2)); //"");
        System.out.println(longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 3)); //"ixoyx3452zzzzzzzzzzzz");
        System.out.println(longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 15)); //"");
        System.out.println(longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 0)); //"");
    }
}
