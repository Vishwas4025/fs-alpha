/*
There are N computers in a network, all the computers are connected as tree 
structure. And one new connection is added in the Network. The computers in 
the network are identified with their IDs, the IDs are numbered between 1 to N.

The connections in the network is given as coonection[i] = [comp-A, comp-B], 
there is a connection between comp-A and comp-B.

Your task is to remove a connection in the network and print it, so that 
all the computers are connected as tree structure. If there are multiple 
options to remove, remove the connection that occurs last in the input.


Input Format:
-------------
Line-1: Two space separated integers N, number of computers.
Next N lines: Two space separated integers, comp-A & comp-B.

Output Format:
--------------
Print the connection which is removed.


Sample Input-1:
---------------
6
1 2
3 4
3 6
4 5
5 6
2 3

Sample Output-1:
---------------
5 6


Sample Input-2:
---------------
4
1 2
2 3
3 4
2 4

Sample Output-2:
---------------
2 4
*/


import java.util.*;

class DSU{
    int[] parent;
    DSU(int n){
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }
    
    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    boolean union(int x1, int x2){
        int p1 = find(x1);
        int p2 = find(x2);
        if(p1 == p2){
            return false;
        }
        parent[p2] = p1;
        return true;
    }
}

public class day30program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[2];
        DSU dsu = new DSU(n);
        
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            if(!dsu.union(a[i]-1, b[i]-1)){
                c[0] = a[i];
                c[1] = b[i];
            }
        }
        System.out.print(c[0]+" "+c[1]);
    }
}

// import java.util.*;

// class DSU{
//     int[] parent;
//     DSU(int n){
//         parent = new int[n];
//         for(int i=0; i<n; i++){
//             parent[i] = i;
//         }
//     }
    
//     int find(int x){
//         if(parent[x] != x){
//             parent[x] = find(parent[x]);
//         }
//         return parent[x];
//     }
    
//     void union(int x1, int x2){
//         int p1 = find(x1);
//         int p2 = find(x2);
//         if(p1!=p2){
//             parent[p2] = p1;
//         }
//     }
// }

// public class day30program1{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] a = new int[n];
//         int[] b = new int[n];
        
//         for(int i=0; i<n; i++){
//             a[i] = sc.nextInt();
//             b[i] = sc.nextInt();
//         }
        
//         int k=n-1 ;
//         while(k>=0){
//             DSU dsu = new DSU(n);
            
//             for(int i=0; i<n; i++){
//                 if(i==k){
//                     continue;
//                 }
//                 dsu.union(a[i]-1, b[i]-1);
//             }
            
//             int count=0;
//             for(int i=0; i<n; i++){
//                 if(dsu.parent[i] == i){
//                     count++;
//                 } 
//             }
//             if(count==1){
//                 System.out.println(a[k]+" "+b[k]);
//                 break;
//             }
//             k--;
//         }
        
//     }
// }