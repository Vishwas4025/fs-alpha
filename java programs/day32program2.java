/*
You're working as a network administrator for a new startup that has set up 
N computers in its office. Due to cost constraints, they’ve haphazardly laid out
Ethernet cables between computers. Each cable connects exactly two computers, 
and no two computers are connected by more than one cable.

The management wants every computer to be part of a fully connected network, 
where any computer can reach any other either directly or indirectly. 
You're allowed to reallocate existing cables by removing them from 
one connection and using them to connect a new pair of computers.

However, you cannot create new cables — you can only reuse the existing ones. 
Your task is to determine the minimum number of such cable reallocation 
operations required to make the network fully connected. 
If it’s not possible with the current number of cables, return -1.

Input Format:
-------------
- N and C (integer): number of computers labeled from 0 to n - 1, and number 
of connections.
- C connections (List of integer pairs): each pair [a, b] represents 
a cable directly connecting computers a and b

Output Format:
--------------
An integer result.


Sample Input-1:
---------------
4 3
0 1
0 2
1 2

Sample Output-1:
----------------
1


Sample Input-2:
---------------
6 5
0 1
0 2
0 3
1 2
1 3

Sample Output-2:
----------------
2


Sample Input-3:
---------------
6 4
0 1
0 2
0 3
1 2


Sample Output-3:
----------------
-1
*/

import java.util.*;

class DSU{
    int[] parent;
    DSU(int n){
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }
    }
    int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    boolean union(int x1, int x2){
        int p1=find(x1);
        int p2=find(x2);
        if(p1==p2){
            return false;
        }
        parent[p2]=p1;
        return true;
    }
}
public class day32program2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[][] connections = new int[c][2];
        for(int i=0; i<c; i++){
            connections[i][0] = sc.nextInt();
            connections[i][1] = sc.nextInt();
        }
        
        DSU dsu = new DSU(n);
        int cablesLeft = 0;
        for(int i=0; i<c; i++){
            if(!dsu.union(connections[i][0], connections[i][1])){
                cablesLeft++;
            }
        }
        
        int numOfGroups = 0;
        for(int i=0; i<n; i++){
            if(dsu.parent[i]==i){
                numOfGroups++;
            }
        }
        
        int cablesReq = numOfGroups-1;
        if(cablesLeft>=cablesReq){
            System.out.print(cablesReq);
            return;
        }
        System.out.print(-1);
    }
}