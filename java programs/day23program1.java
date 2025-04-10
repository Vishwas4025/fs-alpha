/*
MotorSport Ltd hosting a Racing Championship. 
Ajith is participating in car races. Each race start and end in perticular time intervals.

You are given an array of racing time intervals consisting of
start and end times [[s1,e1],[s2,e2],...] (s < e ) of N races, in which Ajith has to participate.
Your task is to determine whether Ajith can participate in all the races or not.

NOTE: If a race starts at time 'a' ends at time 'b', 
another race can start at 'b'.

Input Format:
-------------
Line-1: An integer N, number of races Ajith has to participate.
Next N lines: Two space separated integers, start and end time of each race.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
3
0 30
5 10
15 20

Sample Output-1:
----------------
false

Sample Input-2:
---------------
3
0 10
15 25
30 35

Sample Output-2:
----------------
true

*/

import java.util.*;

public class day23program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int[][] arr = new int[rows][2];
        for(int r=0; r<rows; r++){
            for(int c=0; c<2; c++){
                arr[r][c] = sc.nextInt();
            }
        }
        
        Arrays.sort(arr,(arr1, arr2) -> arr1[0]-arr2[0] );
        
        int prevEnd = 0;
        boolean result = true;
        for(int r=0; r<rows; r++){
            if(prevEnd <= arr[r][0]){
                prevEnd = arr[r][1];
            }
            else{
                result = false;
                break;
            }
        }
        System.out.print(result);
    }
}