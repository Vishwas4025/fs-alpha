/*
Bablu is working in a construction field.
He has N number of building blocks, where the height and width of all the blocks are same.
And the length of each block is given in an array, blocks[].

Bablu is planned to build a wall in the form of a square.
The rules to cunstruct the wall are as follows:
	- He should use all the building blocks.
	- He should not break any building block, but you can attach them with other.
	- Each building-block must be used only once.
	
Your task is to check whether Bablu can cunstruct the wall as a square
with the given rules or not. If possible, print true. Otherwise, print false.

Input Format:
-------------
Line-1: An integer N, number of BuildingBlocks.
Line-2: N space separated integers, length of each block.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
6
1 1 6 5 5 6 

Sample Output-1:
----------------
true


Sample Input-2:
---------------
6
5 3 2 5 5 6

Sample Output-2:
----------------
false
*/

import java.util.*;

public class day25program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        if (n < 4 || sum % 4 != 0) {
            System.out.println(false);
            return;
        }

        int target = sum / 4;
        Arrays.sort(arr);
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }

        int[] sides = new int[4];
        boolean canFormSquare = dfs(arr, 0, sides, target);
        System.out.println(canFormSquare);
    }

    public static boolean dfs(int[] arr, int index, int[] sides, int target) {
        if (index == arr.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + arr[index] <= target) {
                sides[i] += arr[index];
                if (dfs(arr, index + 1, sides, target)) {
                    return true;
                }
                sides[i] -= arr[index];
            }

            if (sides[i] == 0) break;
        }

        return false;
    }

}

// import java.util.*;

// public class program{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         int sum=0;
//         for(int i=0; i<n; i++){
//             arr[i] = sc.nextInt();
//             sum += arr[i];
//         }
        
//         int target = sum/4;
//         int[] visited = new int[n];
//         List<Integer> sides = new ArrayList<>();
        
//         backtrack(0, 0, sides, target, arr, visited);
//         if(sides.size()==4){
//             for(int i=0; i<n; i++){
//                 if(visited[i]==0){
//                     System.out.print(false);
//                     return;
//                 }
//             }
//             System.out.print(true);
//             return;
//         }
//         System.out.print(false);
        
//     }
    
//     public static void backtrack(int ind, int sidelen, List<Integer> sides, int target, int[] arr, int[] visited){
//         if(ind>=arr.length || sidelen > target){
//             return;
//         }
//         if(sidelen == target){
//             sides.add(1);
//             return;
//         }
//         if(ind<arr.length && visited[ind]!=1 && sidelen <= target){
//             sidelen = sidelen+arr[ind];
//             System.out.println(sidelen);
//             visited[ind]=1;
//         }
        
//         visited[ind] = 1;
//         backtrack(ind+1, sidelen, sides, target, arr, visited);
//         visited[ind] = 0;
//         backtrack(ind+2, sidelen, sides, target, arr, visited);
//     }
// }











