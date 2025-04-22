/*
Vihaar is working with strings. 
He is given two strings A and B, and another string T,
 where the length of A and B is same.
 
You can find the relative groups of letters from A and B,
using the following rule set:
	- Equality rule: 'p' == 'p'
 	- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
 	- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.
 	
Vihaar has to form the relatively smallest string of T,
using the relative groups of letters.
 
For example, if A ="pqr" and B = "rst" , 
then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

The relatives groups formed using above rule set are as follows: 
[p, r, t] and [q,s] and  String T ="tts", then relatively smallest string is "ppq".
 
You will be given the strings A , B and T.
Your task is to help Vihaar to find the relatively smallest string of T.
 
Input Format:
-------------
Three space separated strings, A , B and T
 
Output Format:
--------------
Print a string, relatively smallest string of T.
 
 
Sample Input-1:
---------------
kmit ngit mgit
 
Sample Output-1:
----------------
 ggit
 
Explanation: 
------------
The relative groups using A nd B are [k, n], [m, g], [i], [t] and
the relatively smallest string of T is "ggit"
 
 
Sample Input-2:
---------------
attitude progress apriori
 
Sample Output-2:
----------------
 aaogoog
 
 Explanation: 
 ------------
 The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
 the relatively smallest string of T is "aaogoog"
*/


//disjoint union set question
public class day28program2{

}

// import java.util.*;
// public class day28program2 {
// 	public static void main(String[] args) {
// 		String s1 = "attitude";
// 		String s2 = "progress";
// 		LinkedHashMap<Integer,List<Character>> map = new LinkedHashMap<>();

// 		for(int i=0; i<s1.length(); i++){
// 			char c1 = s1.charAt(i);
// 			char c2 = s2.charAt(i);

// 			boolean flag = false;
// 			for(int key : map.keySet()){
// 				List<Character> al = map.get(key);
// 				if(al.contains(c1)){
// 					map.get(key).add(c2);
// 					flag=!flag;
// 					break;
// 				}
// 				else if(al.contains(c2)){
// 					map.get(key).add(c1);
// 					flag=!flag;
// 					break;
// 				}
// 			}
// 			if(!flag){
// 				List<Character> al2 = new ArrayList<>();
// 				al2.add(c1);
// 				al2.add(c2);
// 				map.put(i, al2);
// 			}

// 		}

// 		for(int key : map.keySet()){
// 			List<Character> al = map.get(key);
// 			System.out.println(key+" : "+al);
// 		}
// 	}
    
// }