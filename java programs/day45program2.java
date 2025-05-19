/*
Arjun wants to build some homes in a land of size R*C.
He wanted to construct homes in rectangular shape.
The place which is remained will be used for gradening.
Accordingly he has prepared the plan and given as
an 2d array plan[][], where 1 indicates home, and 0 indicates garden area.

A home is set of cells with value 1 in rectangular shape.
He wants to findout all the homes in the plan and store their co-ordinates in 
the following order, coords[i] = [x1,y1,x2,y2], where (x1,y1) is the starting
co-ordinate (top left corner), and (x2,y2) is the ending co-ordinate 
(bottom right corner) of i-th home.

Your task is to help Arjun to find all the homes and return the coords[][] of 
all the homes from top left corner to bottom right corner.

NOTE: No two homes are adjacent to each other in 4 directions,
(left, right, top, bottom).

Input Format:
-------------
Line-1: Two integers R and C, size of the land.
Next R lines: C space separated integers, either 0 or 1
0- represents garden area land and 1- represents the home.

Output Format:
--------------
Print 2d array, the co-ordinates of all homes.


Sample Input-1:
---------------
2 3
1 0 0
0 1 1
 
Sample Output-1:
----------------
[0, 0, 0, 0][1, 1, 1, 2]


Sample Input-2:
---------------
4 4
1 1 0 1
0 0 0 0
1 1 0 1
1 1 0 1
 
Sample Output-2:
----------------
[0, 0, 0, 1][0, 3, 0, 3][2, 0, 3, 1][2, 3, 3, 3]
*/



// import java.util.*;

// public class program{
//     public static void main(String[] args ){
//         Scanner sc = new Scanner(System.in);
//         int m = sc.nextInt();
//         int n = sc.nextInt();
//         int[][] grid = new int[m][n];
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 grid[i][j] = sc.nextInt();
//             }
//         }
        
//         List<List<Integer>> plan = new ArrayList<>();
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(grid[i][j] == 1 ){
//                     List<Integer> al = new ArrayList<>();
//                     int[] end = bfs(grid, i,j);
//                     al.add(i);
//                     al.add(j);
//                     al.add(end[0]);
//                     al.add(end[1]);
//                     plan.add(new ArrayList(al) );
//                 }
//             }
//         }
        
//         for(List<Integer> l:plan ){
//             System.out.print(l);
//         }
//     }
//     public static int[] bfs(int[][] grid, int r, int c){
//         int m = grid.length;
//         int n = grid[0].length;
//         int[]drow={-1,0,1,0};
//         int[]dcol={0,1,0,-1};
//         Queue<int[]> q = new LinkedList<>();
//         q.add(new int[] {r,c});
//         int row=r;
//         int col=c;
//         while(!q.isEmpty() ){
//             int[] coord=q.poll();
//             row=coord[0];
//             col=coord[1];
//             grid[row][col]=0;
//             for(int i=0; i<4; i++){
//                 int nrow=row+drow[i];
//                 int ncol=col+dcol[i];
//                 if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==1 ){
//                     q.add(new int[]{nrow,ncol});
                    
//                 }
//             }
//         }
//         return new int[]{row,col};
//     }
// }


import java.util.*;

public class day45program2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        List<List<Integer>> plan = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int x1 = i;
                    int y1 = j;
                    int x2 = i;
                    int y2 = j;

                    while(y2 + 1 < n && grid[i][y2 + 1] == 1){
                        y2++;
                    }
                    while (x2 + 1 < m && grid[x2 + 1][y1] == 1) {
                        x2++;
                    }
                    for(int r = x1; r <= x2; r++){
                        for(int c = y1; c <= y2; c++){
                            grid[r][c] = 0;
                        }
                    }

                    List<Integer> home = new ArrayList<>();
                    home.add(x1);
                    home.add(y1);
                    home.add(x2);
                    home.add(y2);
                    plan.add(home);
                }
            }
        }

        for(List<Integer> home : plan){
            System.out.print(home);
        }
    }
}





