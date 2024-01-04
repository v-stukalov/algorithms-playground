package warmup;

import java.util.*;
import java.util.stream.Collectors;

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
public class Wayfair1 {
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

        // list of all students
        // in cycle, create a pair of two
        // request shared courses for the pair
        // DS: id, courses[]

        Map<String, List<String>> map = new HashMap<>();
        for (Pair pair : input) {
            if (!map.containsKey(pair.fst)) {
                map.put((String) pair.fst, new ArrayList<>());
            }
            map.get(pair.fst).add((String) pair.snd);
        }

        Map<String, List<String>> result = new HashMap<>();
        String[] keys = map.keySet().toArray(new String[0]);
        for (int i = 0; i < map.size(); i++) {
            String left = keys[i];
            for (int j = i + 1; j < map.size(); j++) {
                String right = keys[j];
                List<String> common = map.get(right).stream().filter(map.get(left)::contains).collect(Collectors.toList());
                result.put(left + "," + right, common);
            }
        }
        System.out.println(result);
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

    static class Pair<A, B> {

        public final A fst;
        public final B snd;

        public Pair(A fst, B snd) {
            this.fst = fst;
            this.snd = snd;
        }

        public String toString() {
            return "Pair[" + fst + "," + snd + "]";
        }

        public boolean equals(Object other) {
            return other instanceof Pair<?, ?> pair &&
                    Objects.equals(fst, pair.fst) &&
                    Objects.equals(snd, pair.snd);
        }

        public int hashCode() {
            if (fst == null) return (snd == null) ? 0 : snd.hashCode() + 1;
            else if (snd == null) return fst.hashCode() + 2;
            else return fst.hashCode() * 17 + snd.hashCode();
        }

        public static <A, B> Pair<A, B> of(A a, B b) {
            return new Pair<>(a, b);
        }
    }
}
