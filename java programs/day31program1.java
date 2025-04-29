/*
Pranav has a puzzle board filled with square boxes in the form of a grid. Some 
cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

The puzzle board has some patterns formed with boxes in it, 
the patterns may be repeated. The patterns are formed with boxes (1's) only, 
that are connected horizontally and vertically but not diagonally.

Pranav wants to find out the number of unique patterns in the board.

You are given the board in the form of a grid M*N, filled wth 0's and 1's.
Your task is to help Pranav to find the number of unique patterns in 
the puzzle board.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers [0, 1].

Output Format:
--------------
Print an integer, the number of unique patterns in the puzzle board.


Sample Input-1:
---------------
5 5
0 1 0 1 1
1 1 1 0 1 
0 1 0 1 0
1 0 1 1 1
1 1 0 1 0

Sample Output-1:
----------------
3

Explanation-1:
------------
The unique patterns are as follows:
  1			1 1	    1 
1 1 1		  1 ,	1 1
  1	   ,	
   
   
Sample Input-2:
---------------
6 6
1 1 0 0 1 1
1 0 1 1 0 1
0 1 0 1 0 0
1 1 0 0 0 1
0 0 1 0 1 1
1 1 0 1 0 0

Sample Output-2:
----------------
5

Explanation-2:
------------
The unique patterns are as follows:
1 1		1 1		    1		1 1	,	1
1   ,     1 ,	    1 1 ,		
*/


import java.util.*;

class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class day31program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int[][] visited = new int[m][n];
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(arr[r][c]==1 && visited[r][c]==0){
                    q.add(new Pair(r,c));
                    String s="";
                    while(!q.isEmpty()){
                        Pair p = q.poll();
                        int row=p.row;
                        int col=p.col;
                        s= s+"C";
                        visited[row][col]=1;
                        for(int i=0; i<4; i++){
                            int nrow=row+drow[i];
                            int ncol=col+dcol[i];
                            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && arr[nrow][ncol]==1 && visited[nrow][ncol]==0){
                                q.add(new Pair(nrow,ncol));
                                if(nrow>row){
                                    s=s+"U";
                                }
                                else if(nrow<row){
                                    s=s+"D";
                                }
                                else if(ncol>col){
                                    s=s+"R";
                                }
                                else if(ncol<col){
                                    s=s+"L";
                                }
                            }
                        }
                        
                    }
                    set.add(s);
                }
            }
        }
        System.out.print(set.size());
    }
}