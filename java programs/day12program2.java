// /*Mr. Kejriwal purchased a digital clock, it shows the time in "hh:mm" 24 hr format.
// Due to technical issue, in the place of some digits of displays '#' symbol.

// As Mr Kejriwal is an IIT student also, he got an idea to find the number of 
// valid times by replacing '#' with valid digits between 0-9.

// You are given the time as a string T.
// Your task is to help Mr Kejriwal to find the number of possible valid times.

// NOTE:
// -----
// The valid time is in the range of 00:00 to 23:59.


// Input Format:
// -------------
// A string T, the time in the (24-hr) format as "hh:mm" 

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// #6:00

// Sample Output-1:
// ----------------
// 2

// Explanation:
// ------------
// The valid times after replacing # with 0 or 1, are "06:00", "16:00". 


// Sample Input-2:
// ---------------
// 0#:0#

// Sample Output-2:
// ----------------
// 100

// Explanation:
// ------------
// To make the given time valid, replace 1st # with 0-9 digits and 2nd with the same.
// So, totally we have 100 ways.
// */

import java.util.*;

public class day12program2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String [] time = input.split(":");
        String hours = time[0];
        String mins = time[1];
        
        int prod=1;
        if(hours.charAt(0)=='#' && hours.charAt(1)=='#'){
            prod*=24;
        }
        else if(hours.charAt(1)=='#'){
            int h = hours.charAt(0)-'0';
            if(h == 2){
                prod*=4;
            }
            else{
                prod*=10;
            }
        }
        else if(hours.charAt(0)=='#'){
            int h = hours.charAt(1)-'0';
            if(h > 3){
                prod*=2;
            }
            else{
                prod*=3;
            }
        }
        
        if(mins.charAt(0)=='#' && mins.charAt(1)=='#'){
            prod*=60;
        }
        else if(mins.charAt(1)=='#'){
            prod*=10;
        }
        else if(mins.charAt(0)=='#'){
            prod*=6;
        }
        
        System.out.print(prod);
    }
}