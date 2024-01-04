public class StripComments {

    private static String removeTailingSpaces(String s) {
        if (s.length() < 1)
            return s;
        int cutoff = s.length() - 1;
        while (cutoff>-1 && s.charAt(cutoff) == ' ') {
            cutoff--;
        }
        return s.substring(0, ++cutoff);
    }

    public static String stripComments(String text, String[] commentSymbols) {
        if (commentSymbols == null || commentSymbols.length == 0)
            return text;
        if (text == null || "".equals(text))
            return text;
        StringBuilder sb = new StringBuilder();
        String[] lines = text.split("\\n");
        for (String line : lines) {
            int min = line.length();
            for (String sym : commentSymbols) {
                int indexOfSym = line.indexOf(sym);
                if (indexOfSym > -1 && indexOfSym < min) {
                    min = indexOfSym;
                }
            }
            sb.append("\n").append(removeTailingSpaces(line.substring(0, min)));
        }
        return sb.substring(1);
    }

    public static void main(String[] args) {
        System.out.println("[" + removeTailingSpaces(" ") + "]");
        System.out.println("[" + removeTailingSpaces("  abc") + "]");
        System.out.println("[" + removeTailingSpaces("  abc  ") + "]");
        System.out.println(stripComments("a\n   b\nc", new String[]{"#", "$"}));
        System.out.println(stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"}));
        System.out.println(stripComments("a #b\nc\nd $e f g", new String[]{"#", "$"}));
    }
}