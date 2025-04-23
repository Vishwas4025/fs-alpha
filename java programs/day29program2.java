/*
You are a database integrity engineer working for a global cloud company. 
Your team maintains a distributed database network, where each server either:
    - Stores equivalent data to another server (serverX == serverY).
    - Stores different data from another server (serverX != serverY).

The transitive consistency rule must be followed:
    - If A == B and B == C, then A == C must be true.
    - If A == B and B != C, then A != C must be true.

Your task is to analyze the given constraints and determine whether they 
follow transitive consistency. If all relations are consistent, return true; 
otherwise, return false

Input Format:
-------------
Space separated strnigs, list of relations

Output Format:
--------------
Print a boolean value, whether transitive law is obeyed or not.


Sample Input-1:
---------------
a==b c==d c!=e e==f

Sample Output-1:
----------------
true


Sample Input-2:
---------------
a==b b!=c c==a

Sample Output-2:
----------------
false

Explanation:
------------
{a, b} form one equivalence group.
{c} is declared equal to {a} (c == a), which means {a, b, c} should be equivalent.
However, b != c contradicts b == a and c == a.

Sample Input-3:
---------------
a==b b==c c!=d d!=e f==g g!=d

Sample Output-3:
----------------
true
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
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    void union(int c1, int c2){
        int x1 = find(c1);
        int x2 = find(c2);
        if(x1!=x2){
            if(x1<x2){
                parent[x2]=x1;
            }
            else{
                parent[x1]=x2;
            }
        }
    }
}
public class day29program2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        List<String> al = new ArrayList<>();
        DSU dsu = new DSU(26);
        
        for(int i=0; i<inputs.length; i++){
            int c1=inputs[i].charAt(0)-'a';
            char c2=inputs[i].charAt(1);
            int c3=inputs[i].charAt(3)-'a';
            if(c2=='='){
                dsu.union(c1,c3);
            }
            else{
                al.add(inputs[i]);
            }
        }
        
        boolean res = true;
        for(String s : al){
            int c1=s.charAt(0)-'a';
            int c3=s.charAt(3)-'a';
            int p1 = dsu.find(c1);
            int p2 = dsu.find(c3);
            if(p1==p2){
                res = false;
                break;
            }
        }
        System.out.print(res);
    }
}
