import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class APlusB {

    static Double multiply(Double a, Double b) {
        return a.doubleValue() * b.doubleValue();
    }

    static int sumOfTwoDigits(int first_digit, int second_digit) {
        return first_digit + second_digit;
    }
//    public static int fib(int n){
//        if(n<=0) return 0;
//        if(n==1) return 1;
//        return fib(n-2)+fib(n-1);
//    }

    private static int[] memo = new int[1001];

    public static int fib(int n) {
        if (n <= 1)
            return n;
        if (memo[n] == 0)
            memo[n] = fib(n - 2) + fib(n - 1);
        return memo[n];
    }

    public static String[] solution(String s) {
        int n = s.length();
        if (n % 2 > 0) {
            s = s + "_";
            n++;
        }
        String[] r = new String[n / 2];
        int k = 0;
        for (int i = 0; i < n - 1; i = i + 2) {
            r[k++] = "" + s.charAt(i) + s.charAt(i + 1);
        }
        return r;
    }

    static String process(String s, String delim) {
        String[] chunks = s.split(delim);
        String first = chunks[0];
        if (chunks.length < 2)
            return first;

        StringBuilder sb = new StringBuilder(first);
        for (int i = 1; i < chunks.length; i++) {
            String chunk = chunks[i];
            sb.append(("" + chunk.charAt(0)).toUpperCase() + chunk.substring(1));
        }
        return sb.toString();
    }

    static String toCamelCase(String s) {
        for (String delim : Arrays.asList("_", "-")) {
            s = process(s, delim);
        }
        return s;
    }

    public static boolean isValid(char[] walk) {
        if (walk.length != 10)
            return false;
        int up = 0;
        int left = 0;
        for (char w : walk) {
            switch (w) {
                case 'n':
                    up++;
                    break;
                case 's':
                    up--;
                    break;
                case 'w':
                    left++;
                    break;
                case 'e':
                    left--;
                    break;
                default:
            }
        }
        return up == 0 && left == 0;
    }

    private static boolean isMark(String word) {
        if (word.length() > 1) return false;
        return Arrays.asList("?", "!", ":", ";", ".", ",").contains(word);
    }

    public static String pigIt(String str) {
        StringBuilder sb = new StringBuilder();
        for (String word : str.split(" ")) {
            int n = word.length();
            if (isMark(word))
                sb.append(word.concat(" "));
            else if (n == 1)
                sb.append(word.concat("ay").concat(" "));
            else
                sb.append(word.substring(1, n).concat(word.substring(0, 1).concat("ay").concat(" ")));
        }
        String pig = sb.toString();
        return pig.substring(0, pig.length() - 1);
    }

    private static Character reflection(Character c) {
        if (c == ']') return '[';
        else if (c == '}') return '{';
        else if (c == ')') return '(';
        else throw new IllegalArgumentException();
    }

    public static boolean isValid(String braces) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < braces.length(); i++) {
            char c = braces.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (stack.isEmpty() || stack.pop() != reflection(c))
                return false;
        }
        return stack.isEmpty();
    }

    public static int duplicateCount(String text) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            String s = Character.toString(text.charAt(i)).toLowerCase();
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        int count = 0;
        for (Integer value : map.values()) {
            if (value > 1) {
                count++;
            }
        }
        return count;
    }

    public static boolean comp(int[] a, int[] b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        int n = a.length;
        if (n != b.length)
            return false;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            if (a[i] * a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
//        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};

        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{132, 14641, 20736, 361, 25921, 361, 20736, 361};

        System.out.println(comp(a, b));
        System.out.println(isValid("()"));
        System.out.println(pigIt("Pig latin is cool")); // igPay atinlay siay oolcay"
        System.out.println(pigIt("This is my string")); // hisTay siay ymay tringsay"
        System.out.println(toCamelCase("the_Stealth-Warrior"));
        System.out.println(toCamelCase("The-Stealth_Warrior"));
        System.out.println(Arrays.toString(solution("abcde")));
        System.out.println(multiply(Double.valueOf("1234.90"), Double.valueOf("-0.90")));
        System.out.println(fib(32)); //2178309

//        Scanner s = new Scanner(System.in);
//        int a = s.nextInt();
//        int b = s.nextInt();
//        System.out.println(sumOfTwoDigits(a, b));
    }
}