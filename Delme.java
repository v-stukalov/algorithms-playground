import java.util.*;

/*
You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends.
The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.

Write a function that takes in a collection of (student ID number, course name) pairs and returns, for every pair of students,
a collection of all courses they share.


Sample Input:

student_course_pairs_1 = [
["58", "Linear Algebra"],
["94", "Art History"],
["94", "Operating Systems"],
["17", "Software Design"],
["58", "Mechanics"],
["58", "Economics"],
["17", "Linear Algebra"],
["17", "Political Science"],
["94", "Economics"],
["25", "Economics"],
["58", "Software Design"],
]

Sample Output (pseudocode, in any order):

find_pairs(student_course_pairs_1) =>
{
"58,17": ["Software Design", "Linear Algebra"]
"58,94": ["Economics"]
"58,25": ["Economics"]
"94,25": ["Economics"]
"17,94": []
"17,25": []
}



Additional test cases:

Sample Input:

student_course_pairs_2 = [
["0", "Advanced Mechanics"],
["0", "Art History"],
["1", "Course 1"],
["1", "Course 2"],
["2", "Computer Architecture"],
["3", "Course 1"],
["3", "Course 2"],
["4", "Algorithms"]
]



Sample output:

find_pairs(student_course_pairs_2) =>
{
"1,0":[]
"2,0":[]
"2,1":[]
"3,0":[]
"3,1":["Course 1", "Course 2"]
"3,2":[]
"4,0":[]
"4,1":[]
"4,2":[]
"4,3":[]
}

Sample Input:
student_course_pairs_3 = [
["23", "Software Design"],
["3", "Advanced Mechanics"],
["2", "Art History"],
["33", "Another"],
]


Sample output:

find_pairs(student_course_pairs_3) =>
{
"23,3": []
"23,2": []
"23,33": []
"3,2": []
"3,33": []
"2,33": []
}


n: number of student,course pairs in the input
s: number of students
c: total number of courses being offered (note: The number of courses any student can take is bounded by a small constant)
*/
public class Delme {

    private static Map<String, List<String>> solution(String[][] pairs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            String id = pair[0];
            String course = pair[1];
            List<String> courses = null;
            if (map.containsKey(id)) {
                courses = map.get(id);
            } else {
                courses = new ArrayList<>();
            }
            courses.add(course);
            map.put(id, courses);
        }
        Map<String, List<String>> result = new HashMap<>();
        String[] students = map.keySet().toArray(new String[0]);
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            String s1 = students[i];
            List<String> l1 = map.get(s1);
            for (int j = i + 1; j < n; j++) {
                String s2 = students[j];
                List<String> l2 = map.get(s2);
                result.put(s1 + ", " + s2, intercec(l1, l2));
            }
        }
        return result;
    }

    private static List<String> intercec(List<String> l1, List<String> l2) {
        List<String> l3 = new ArrayList<>();
        for(String s1: l1){
            for(String s2: l2){
                if(s2.equals(s1)){
                    l3.add(s2);
                }
            }
        }
        return l3;
    }
    int numberOfWays(int[] a, int k) {
        int c = 0;
        int n = a.length;
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            int p = Arrays.binarySearch(a, i, n - 1, a[i] - k);
            if (p >= 0) c++;
        }
        return c;
    }
    public static void main(String[] args) {
        String[][] pairs = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"58", "Software Design"}
        };
        Map<String, List<String>> map = solution(pairs);
        for (String pair : map.keySet()) {
            System.out.println(pair + ": " + Arrays.toString(
                    map.get(pair).toArray(new String[0])));
        }
    }
}
