// There are N people having some amount in their credit cards, both +ve or -ve.
// You are given the amounts as an integer array cards[], in rupees.

// You are allowed to perform only one operation:
//     - pick N-1 credit cards add 1rupee to each card.
    
// Your task is to return the minimum number of operations required to
// make all the credit cards to have the same amount.

// Input Format:
// -------------
// Line-1: An integer N
// Line-2: N space separated integers, cards[]

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 4
// 2 5 4 3

// Sample Output-1:
// ----------------
// 6

// Explanation:
// ------------
// 6 operations are required.
// [2, 5, 4, 3]  =>  [3, 5, 5, 4]  =>  [4, 5, 6, 5]  =>  [5, 6, 6, 6]
// =>  [6, 7, 7, 6] => [7, 8, 7, 7] => [8, 8, 8, 8]


// Sample Input-2:
// ---------------
// 5
// 4 5 9 8 5

// Sample Output-2:
// ----------------
// 11


// import java.util.*;

// public class program{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         for(int i=0; i<n; i++){
//             arr[i] = sc.nextInt();
//         }
        
//         int count=0;
//         while(!isSame(arr)){
//             for(int i=0; i<arr.length; i++){
//                 arr[i]=arr[i]+1;
//             }
//             Arrays.sort(arr);
//             count++;
//         }
//         System.out.print(count);
//     }
//     public static boolean isSame(int[] arr){
//         int n=arr.length;
//         for(int i=0; i<n-1; i++){
//             if(arr[i]!=arr[n-1]){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
import java.util.*;
public class day37program3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        ArrayList<Integer> pq=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
            pq.add(arr[i]);
        }
        int re=0;
        while(function(pq)){
            re++;
            Collections.sort(pq);
            for(int i=0;i<n-1;i++){
                pq.set(i,pq.get(i)+1);
            }
            
        }
        System.out.print(re);
    }
    public static boolean function(ArrayList<Integer> pq){
        HashSet<Integer> h=new HashSet<>();
        for(int i=0;i<pq.size();i++)h.add(pq.get(i));
        return h.size()!=1;
    }

}