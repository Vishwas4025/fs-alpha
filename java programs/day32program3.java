/*
You are given a crystal with an energy level n. Your goal is to discover all 
the different ways this crystal could have been created by combining smaller shards.

Each combination must:
- Use only shards with energy values between 2 and n - 1.
- Be represented as a list of shard values whose product equals n.
- Use any number of shards (minimum 2), and the order is ascending order.

Your task is to return all unique shard combinations that can multiply together
to recreate the original crystal.

Example 1:
---------
Input:
28

Output:
[[2, 14], [2, 2, 7], [4, 7]]

Example 2:
----------
Input:
23

Output:
[]



Constraints:
- 1 <= n <= 10^4
- Only shards with energy between 2 and n - 1 can be used.
*/

import java.util.*;

public class day32program3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> al = new ArrayList<>();
        backtrack(2, 1, n, subset, al);
        System.out.print(al);
    }
    
    public static void backtrack(int start, int prod, int n, List<Integer> subset, List<List<Integer>> al){
        if(prod>=n){
            if(prod==n){
                al.add(new ArrayList(subset));
            }
            return;
        }
        for(int i=start; i<=n/2; i++){
            if(n%i==0){
                subset.add(i);
                backtrack(i, prod*i, n, subset, al);
                subset.remove(subset.size()-1);
            }
        }
    }
}