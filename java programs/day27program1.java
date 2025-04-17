/*
Given a integer value N, indicates number of bits in a binary number.

Your task is to design a Binary Code System, where two consecutive 
values in BCS having N bits, must have one bit difference only. 
For example refer the sample testcases.

Find and print the integer values of BCS, starting from 0.


Input Format:
-------------
A integer N, number of bits in BCS

Output Format:
--------------
Print the list of integer values, in BCS form. 


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[0, 1, 3, 2]

Explanation:
------------
00 - 0
01 - 1
11 - 3
10 - 2

Sample Input-2:
---------------
3

Sample Output-2:
----------------
[0, 1, 3, 2, 6, 7, 5, 4]

Explanation:
------------
000 - 0
001 - 1
011 - 3
010 - 2
110 - 6
111 - 7
101 - 5
100 - 4

*/



import java.util.*;

public class day27program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        String binary = "01";
        List<Integer> result = new ArrayList<>();
        
        genBinary(n, binary, new StringBuilder(), result);
        System.out.println(result);
    }
    
    public static void genBinary(int n, String binary, StringBuilder sb, List<Integer> result){
        if(sb.length()==n){
            int num = Integer.parseInt(sb.toString(),2);
            int gray = num^(num>>1);
            result.add(gray);
            return;
        }
        for(int i=0; i<binary.length(); i++){
            char c = binary.charAt(i);
            sb.append(c);
            genBinary(n, binary, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }   
}



// import java.util.*;
// public class program{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         StringBuilder sb = new StringBuilder();
//         for(int i=0; i<n; i++){
//             sb.append(0);
//         }
        
//         HashSet<Integer> set = new HashSet<>();
        
        
//         genBinary(sb, set, n);
//         System.out.println(set);
//     }
    
//     public static void genBinary(StringBuilder sb, HashSet<Integer> set, int n){
//         if(sb.length()==n){
//             int num = Integer.parseInt(sb.toString(),2);
//             set.add(num);
//             return;
//         }
//         for(int i=sb.length()-1; i>=0; i--){
//             char c = sb.charAt(i);
//             if(c=='0'){
//                 sb.setCharAt(i,'1');
//             }else{
//                 sb.setCharAt(i,'0');
//             }
//             int num1 = Integer.parseInt(sb.toString(),2);
//             if(set.contains(num1)){
//                 char c2 = sb.charAt(i);
//                 if(c2=='0'){
//                     sb.setCharAt(i,'1');
//                 }else{
//                     sb.setCharAt(i,'0');
//                 }
//                 continue;
//             }
//             genBinary(sb, set, n);
//         }
//     }
// }