// You are provided with an array of integers called 'score,' with 'n' elements, 
// where 'score[i]' represents the performance score of the ith participant 
// in a competitive event. It is guaranteed that all the scores are distinct.

// The participants' final positions are determined solely by their performance scores, 
// with the top performer ( with highest score), securing the 1st position, 
// the second-best performer obtaining the 2nd position, and so forth. 
// Each participant's rank is directly related to their placement:
// 	- The participant in the 1st position is awarded the 'Champion'
// 	- The participant in the 2nd position receives the 'RunnerUp-1'
// 	- The participant in the 3rd position is granted the 'RunnerUp-2'
// 	- For participants ranked from 4th to 'n,' their rank corresponds to 
// 	their position (i.e., the participant in the xth position is assigned the rank 'x').

// Your task is to generate an array named 'answer' of size 'n' 
// Each element 'answer[i]' in this array should represent the rank achieved 
// by the ith participant.

// Input Format:
// -------------
// Line-1: An integer N, number of participants.
// Line-2: N space seprated integers, scores[].

// Output Format:
// --------------
// Print the list of ranks of the participants.


// Sample Input-1:
// ---------------
// 5
// 10 3 9 8 4

// Sample Output-1:
// ----------------
// [Champion, 5, RunnerUp-1, RunnerUp-2, 4]


// Sample Input-2:
// ---------------
// 8
// 10 3 9 4 2 7 6 1

// Sample Output-2:
// ----------------
// [Champion, 6, RunnerUp-1, 5, 7, RunnerUp-2, 4, 8]


import java.util.*;

public class day18program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> al = new ArrayList<>();
        Map<Integer, Queue<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            al.add(num);
            indexMap.putIfAbsent(num, new LinkedList<>());
            indexMap.get(num).add(i);
        }

        List<String> result = new ArrayList<>(Collections.nCopies(n, ""));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(al);

        int i = 1;
        while (!pq.isEmpty()) {
            int value = pq.poll();
            int ind = indexMap.get(value).poll(); // Get correct index
            if (i == 1) {
                result.set(ind, "Champion");
            } 
            else if (i == 2) {
                result.set(ind, "RunnerUp-1");
            } 
            else if (i == 3) {
                result.set(ind, "RunnerUp-2");
            } 
            else {
                result.set(ind, Integer.toString(i));
            }
            i++;
        }
        System.out.println(result);
    }
}


// import java.util.*;

// public class program {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         List<Integer> al = new ArrayList<>();
//         for(int i=0; i<n; i++){
//             al.add(sc.nextInt());
//         }
        
//         List<String> result = new ArrayList<>();
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//         for(int i=0; i<n; i++){
//             pq.add(al.get(i));
//         }
        
//         int i=1;
//         while(i<=n){
//             int ind = al.indexOf(pq.poll());
//             if(i==1){
//                 result.add(ind, "Champion");
//             }
//             else if(i==2){
//                 result.add(ind, "RunnerUp-1");
//             }
//             else if(i==3){
//                 result.add(ind, "RunnerUp-2");
//             }
//             else{
//                 result.add(ind, Integer.toString(i));
//             }
//             i++;
//         }
        
//         System.out.println(result);
        
        
//     }
// }

