// /*
// You are a student organizer, and you are given n students. Each student has two values:
//     Student Name: A unique identifier for the student.
//     Score: The score achieved by the student.

// Your goal is to organize these students in the order of their scores (highest score first). 
// If two students have the same score, order them alphabetically by their names. 

// Write a program to simulate how the students are organized using a priority queue.

// Input Format:
// -------------
// Line-1: An integer, N
// Next N lines: space sepaarted string and integer, name and score of each student.

// Output Format:
// --------------
// Organized students data as shown in samples.


// Sample Input-1:
// ---------------
// 5
// Alice 85
// Bob 92
// Charlie 78
// Diana 95
// Eve 88

// Sample Output-1:
// ----------------
// (Diana, 95)
// (Bob, 92)
// (Eve, 88)
// (Alice, 85)
// (Charlie, 78)


// Sample Input-2:
// ---------------
// 4
// Bob 90
// Charlie 85
// Diana 92
// Alice 85

// Sample Output-2:
// ----------------
// (Diana, 92)
// (Bob, 90)
// (Alice, 85)
// (Charlie, 85)

// */



// using priority queue
import java.util.*;
class Student {
    String name;
    int score;
    Student(String name, int score){
        this.name = name;
        this.score = score;
    }
    
    @Override
    public String toString(){
        return name+" "+score;
    }
}
public class day2program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Student> q = new PriorityQueue<>((Student1, Student2 ) -> {
            int value = Integer.compare(Student2.score, Student1.score);
            if(value==0){
                return Student1.name.compareTo(Student2.name);
            }
            return value;
        });
             
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            String name = sc.next();
            int score = sc.nextInt();
            q.add(new Student(name, score) );
        }
        
        while(!q.isEmpty() ){
            Student s = q.poll();
            System.out.println(s);
        }
        
    } 
}



// // Without using priority Queue
// import java.util.*;
// public class day2program1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         HashMap<String,Integer> map = new HashMap<>();
//         for(int i=0; i<n; i++){
//             String name = sc.next();
//             int score = sc.nextInt();
//             map.put(name, score);
//         }
//         List<String> sortedList = new ArrayList<>(map.keySet());
//         Comparator<String> comp = new Comparator<>(){
//             public int compare(String a, String b){
//                 int diff = map.get(b)-map.get(a);
//                 if(diff==0){
//                     return a.compareTo(b);
//                 }
//                 return diff;
//             }
//         };
//         Collections.sort(sortedList,comp);
//         for(String key : sortedList){
//             System.out.println(key+" "+map.get(key));
//         }
//     }
// }