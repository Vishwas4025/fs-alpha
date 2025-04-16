/*
Given two strings S1 and S2, find if S2 can match S1 or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and 
distinct non-empty substring in S2, where each non-empty substring in S2
also has a corresponding letter in S1.

Return true,if S2 can match S1.
Otherwise false.

Input Format:
-------------
Line-1 -> Two strings S1 and S2

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
abab kmitngitkmitngit

Sample Output-1:
----------------
true


Sample Input-2:
---------------
aaaa kmjckmjckmjckmjc

Sample Output-2:
----------------
true

Sample Input-3:
---------------
mmnn pqrxyzpqrxyz

Sample Output-3:
----------------
false
*/

import java.util.*;
public class day26program1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(wordPatternMatch(s1, s2));
    }
    
    public static boolean wordPatternMatch(String s1, String s2) {
        return backtrack(s1, s2, 0, 0, new HashMap<>(), new HashSet<>());
    }

    private static boolean backtrack(String s1, String s2, int i, int j, Map<Character,String> map, Set<String> used) {
        if (i == s1.length() && j == s2.length()) return true;
        if (i == s1.length() || j == s2.length()) return false;

        char ch = s1.charAt(i);
        if (map.containsKey(ch)) {
            String mapped = map.get(ch);
            if (!s2.startsWith(mapped, j)) return false;
            return backtrack(s1, s2, i + 1, j + mapped.length(), map, used);
        }

        for (int k = j + 1; k <= s2.length(); k++) {
            String candidate = s2.substring(j, k);
            if (used.contains(candidate)) continue;

            map.put(ch, candidate);
            used.add(candidate);

            if (backtrack(s1, s2, i + 1, k, map, used)) return true;

            map.remove(ch);
            used.remove(candidate);
        }
        return false;
    }

}