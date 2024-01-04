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

import java.util.*;
import java.util.stream.Collectors;

public class Wayfair {
    private static class Pair {
        String key;
        String value;

        static Pair of(String key, String value) {
            Pair pair = new Pair();
            pair.key = key;
            pair.value = value;
            return pair;
        }
    }

    private static Map<String, Set<String>> findPairs(Map<String, List<String>> students) {
        Map<String, Set<String>> pairs = new HashMap<>();
        String[] ids = students.keySet().toArray(new String[0]);
        for (int i = 0; i < ids.length; i++) {
            String left = ids[i];
            List<String> c_left = students.get(left);
            for (int j = i + 1; j < ids.length; j++) {
                String right = ids[j];
                pairs.put(left + "," + right, intersect(c_left, students.get(right)));
            }
        }
        return pairs;
    }

    private static Set<String> intersect(List<String> left, List<String> right) {
        return left.stream()
                .distinct()
                .filter(right::contains)
                .collect(Collectors.toSet());
    }

    private static Map<String, List<String>> students(Pair[] input) {
        Map<String, List<String>> students = new HashMap<>();
        for (Pair pair : input) {
            if (students.containsKey(pair.key)) {
                students.get(pair.key).add(pair.value);
            } else {
                List<String> courses = new ArrayList<>();
                courses.add(pair.value);
                students.put(pair.key, courses);
            }
        }
        return students;
    }

    public static void main(String[] args) {
        Pair[] input = new Pair[]{
                Pair.of("58", "Linear Algebra"),
                Pair.of("94", "Art History"),
                Pair.of("58", "Linear Algebra"),
                Pair.of("94", "Operating Systems"),
                Pair.of("17", "Software Design"),
                Pair.of("58", "Mechanics"),
                Pair.of("58", "Economics"),
                Pair.of("17", "Linear Algebra"),
                Pair.of("17", "Political Science"),
                Pair.of("94", "Economics"),
                Pair.of("25", "Economics"),
                Pair.of("58", "Software Design")
        };

        Map<String, List<String>> students = students(input);
        Map<String, Set<String>> pairs = findPairs(students);
        System.out.println(pairs);
/*
        {
            "58,17": ["Software Design", "Linear Algebra"]
            "58,94": ["Economics"]
            "58,25": ["Economics"]
            "94,25": ["Economics"]
            "17,94": []
            "17,25": []
        }
*/
    }
}
