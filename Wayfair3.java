import java.util.*;

/*
Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

For example:
logs1 = [
    ["58523", "user_1", "resource_1"],
    ["62314", "user_2", "resource_2"],
    ["54001", "user_1", "resource_3"],
    ["200", "user_6", "resource_5"],
    ["215", "user_6", "resource_4"],
    ["54060", "user_2", "resource_3"],
    ["53760", "user_3", "resource_3"],
    ["58522", "user_22", "resource_1"],
    ["53651", "user_5", "resource_3"],
    ["2", "user_6", "resource_1"],
    ["100", "user_6", "resource_6"],
    ["400", "user_7", "resource_2"],
    ["100", "user_8", "resource_6"],
    ["54359", "user_1", "resource_3"],
]


We would like to compute user sessions, specifically: write a function that takes the logs and returns a data structure that associates to each user their earliest and latest access times.

Example:
{'user_1': [54001, 58523],
 'user_2': [54060, 62314],
 'user_3': [53760, 53760],
 'user_5': [53651, 53651],
 'user_6': [2, 215],
 'user_7': [400, 400],
 'user_8': [100, 100],
 'user_22': [58522, 58522],
}

Example 2:
logs2 = [
    ["300", "user_1", "resource_3"],
    ["599", "user_1", "resource_3"],
    ["900", "user_1", "resource_3"],
    ["1199", "user_1", "resource_3"],
    ["1200", "user_1", "resource_3"],
    ["1201", "user_1", "resource_3"],
    ["1202", "user_1", "resource_3"]
]

Should return:
{'user_1': [300, 1202]}

Example 3:
logs3 = [
    ["300", "user_10", "resource_5"]
]

Should return:
{'user_10': [300, 300]}
*/
public class Wayfair3 {
    public static Map<String, List<Integer>> solution(String[][] logs) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (String[] line : logs) {
            Integer time = Integer.valueOf(line[0]);
            String id = line[1];
            if (!map.containsKey(id)) {
                map.put(id, new ArrayList<>());
            }
            map.get(id).add(time);
        }
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            Integer min = entry.getValue().stream().min(Comparator.comparing(Integer::valueOf)).get();
            Integer max = entry.getValue().stream().max(Comparator.comparing(Integer::valueOf)).get();
            map.put(entry.getKey(), Arrays.asList(min, max));
        }
        return map;
    }

    public static void main(String[] argv) {
        String[][] logs1 = new String[][]{
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_22", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_6"},
                {"54359", "user_1", "resource_3"},
        };

        Map<String, List<Integer>> result1 = solution(logs1);
        for (Map.Entry<String, List<Integer>> entry : result1.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        String[][] logs2 = new String[][]{
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

        Map<String, List<Integer>> result2 = solution(logs2);
        for (Map.Entry<String, List<Integer>> entry : result2.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        String[][] logs3 = new String[][]{
                {"300", "user_10", "resource_5"}
        };

        Map<String, List<Integer>> result3 = solution(logs3);
        for (Map.Entry<String, List<Integer>> entry : result3.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
