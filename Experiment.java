import java.util.*;

/*
You are in charge of a display advertising program. Your ads are displayed on websites all over the internet.
You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain.
Every line consists of a click count and a domain name, like this:

counts = [ "900,google.com",
 "60,mail.yahoo.com",
 "10,mobile.sports.yahoo.com",
 "40,sports.yahoo.com",
 "300,yahoo.com",
 "10,stackoverflow.com",
 "20,overflow.com",
 "5,com.com",
 "2,en.wikipedia.org",
 "1,m.wikipedia.org",
 "1,mobile.sports",
 "1,google.co.uk"]

Write a function that takes this input as a parameter and returns a data structure containing the number of clicks
that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com" counts toward
the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain.
So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the
bottom of the input.)

Sample output (in any order/format):

calculateClicksByDomain(counts) =>
com:                     1345
google.com:              900
stackoverflow.com:       10
overflow.com:            20
yahoo.com:               410
mail.yahoo.com:          60
mobile.sports.yahoo.com: 10
sports.yahoo.com:        50
com.com:                 5
org:                     3
wikipedia.org:           3
en.wikipedia.org:        2
m.wikipedia.org:         1
mobile.sports:           1
sports:                  1
uk:                      1
co.uk:                   1
google.co.uk:            1

n: number of domains in the input
(individual domains and subdomains have a constant upper length)
*/

public class Experiment {
    // map <string, int> -> <domain, count>
    //  "en.wikipedia.org", "wikipedia.org" "org"
    // map <string, int> -> <subdomain, count>

    private static String[] subdomains(String dom) {
        String[] words = dom.split("\\."); // "en", "wikipedia" "org"
        int length = words.length;
        String[] result = new String[length];
        int j = 0;
        result[j] = words[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            String prev = result[j++];
            result[j] = words[i] + "." + prev;
        }
//            result[0] = words[last];// "org"
//            result[1] = words[last-1]+"."+result[0]; // "wikidepia.org"
//            result[2] = words[last-2]+"."+result[1]; // "en.wikidepia.org"
        return result;
    }

    private static Map<String, Integer> parse(String[] counts) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < counts.length; i++) {
            String[] item = counts[i].split(",");
            map.put(item[1], Integer.valueOf(item[0]));
        }
        return map;
    }

    private static Map<String, Integer> total(Map<String, Integer> counts) {
        Map<String, Integer> result = new HashMap<>();
        for (String dom : counts.keySet()) {
            for (String subdomain : subdomains(dom)) {
                if (result.containsKey(subdomain)) {
                    result.put(subdomain, result.get(subdomain) + counts.get(dom));
                } else {
                    result.put(subdomain, counts.get(dom));
                }
            }
        }
        return result;
    }

    public static List<String> subVal(String[] sb) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : sb) {
            StringBuilder sup = new StringBuilder();
            int i = 0;
            while (s.charAt(i) != ',') {
                sup.append(s.charAt(i));
                i++;
            }
            int no = Integer.parseInt(sup.toString());
            int j = s.length() - 1;
            String s1 = "";
            while (j >= i) {
                char ch = s.charAt(j);
                if (ch != '.' || ch != ' ') {
                    if (map.containsKey(s1)) {
                        map.put(s1, map.get(s1) + no);
                    } else {
                        map.put(s1, no);
                    }
                }
                s1 = ch + s1;
                j--;
            }
        }
        List<String> a = new ArrayList<String>();
        for (String str : map.keySet()) {
            String s = map.get(str) + " " + str;
            a.add(s);
        }
        return a;
    }

    public static void main(String[] argv) {
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };
        List<String> k = subVal(counts);
        Collections.sort(k);
        for (String s : k) {
            System.out.println(s);
        }

    }
//        String[] subdomains = subdomains("mobile.sports.yahoo.com");
//        System.out.println(Arrays.toString(subdomains));
//        Map<String, Integer> result = total(parse(counts));
//        for (String dom : result.keySet()) {
//            System.out.println(dom + ": " + result.get(dom));
//        }

}
