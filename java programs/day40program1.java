/*
Pranav has a puzzle board filled with square boxes in the form of a grid.
Some cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

Pranav wants to find out the number of empty spaces which are completely 
surrounded by the square boxes (left, right, top, bottom) in the board.

You are given the board in the form of a grid M*N, filled wth 0's and 1's.
Your task is to help Pranav to find the number of empty groups surrounded by
the boxes in the puzzle board.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the board.
Next M lines: contains N space-separated either 0 or 1.

Output Format:
--------------
Print an integer, the number of empty spaces in the puzzle board.


Sample Input-1:
---------------
6 7
1 1 1 1 0 0 1
1 0 0 0 1 1 0
1 0 0 0 1 1 0
0 1 1 1 0 1 0
1 1 1 0 0 1 1
1 1 1 1 1 1 1

Sample Output-1:
----------------
2

Explanation:
------------
The 2 empty groups are as follows:
1st group starts at cell(1,1), 2nd group starts at cell(3,4).
The groups which are starts at cell(0,4), cell(1,6) and cell(3,0)
are not valid empty groups, because they are not completely surrounded by boxes.


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
1

Explanation:
------------
The only empty group starts at cell(1,1) is surrounded by boxes.
*/


import java.util.*;

class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}

public class day40program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        int[][] grid = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        Queue<Pair> q = new LinkedList<>();
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean isInside=true;
                if(grid[i][j]==0){
                    q.add(new Pair(i,j) );
                    while(!q.isEmpty() ){
                        Pair p = q.poll();
                        int row=p.row;
                        int col=p.col;
                        if(row==0 || row==m-1 || col==0 || col==n-1){
                            isInside=false;
                        }
                        grid[row][col]=1;
                        for(int d=0; d<4; d++){
                            int nrow=row+drow[d];
                            int ncol=col+dcol[d];
                            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==0){
                                q.add(new Pair(nrow,ncol) );
                            }
                        }
                        
                    }
                    if(isInside){
                        count++;
                    }
                }
                
            }
        }
        System.out.print(count);
    }
}