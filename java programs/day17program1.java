// /*
// In the context of linguistic harmony, we define a "harmonious string" as a string where 
// every alphabet it contains appears both in uppercase and lowercase forms. For instance, 
// a string like "pqQpP" is harmonious because it has both 'P' and 'p' as well as 'Q' and 'q'. 
// Conversely, a string like "pqP" is not harmonious as it fails to meet this condition, 
// with 'q' present while 'Q' is absent.

// Your are given a string S, your task is  to return the longest harmonious substring in S. 
// If there are multiple answers meeting this criterion, you should return the one that appears 
// earliest in the string. If there is no harmonious substring, you should return an empty string.

// Input Format:
// -------------------
// A string S

// Output Format:
// -------------------
// Prin the longest harmonious string.


// Sample Input:
// --------------
// QcvcCcq

// Sample Output:
// ---------------
// cCc


// Sample Input:
// --------------
// pqrs

// Sample Output:
// --------------
// ""
// */

import java.util.*;

public class day17program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n=s.length();
        
        for(int k=n; k>1; k--){
            for(int i=0; i+k<=n; i++){
                String sub = s.substring(i,i+k);
                if(isHarmonious(sub)){
                    System.out.print(sub);
                    return;
                }
                
            }
        }
        String res = "";
        System.out.print(res);
    }
    
    public static boolean isHarmonious(String sub){
        for(int i=0; i<sub.length(); i++){
            char c = sub.charAt(i);
            char opp = ' ';
            if (c >= 'A' && c <= 'Z'){
                opp = (char) (c + 32);
            } 
            else if (c >= 'a' && c <= 'z'){
                opp = (char) (c - 32);
            } 
            
            if(sub.indexOf(opp)==-1){
                return false;
            } 
        }
        return true;
    }
}