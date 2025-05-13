/*
Venkatadri is a maths teacher.
He is teaching matrices to his students.
He is given a matrix of size m*n, and it contains only positive numbers.
He has given a task to his students to find the special matrix, 
in the iven matrix A[m][n].
A special matrix has following property:
	- The sum of elements in each row, each column and the two diagonals are equal.
	- Every 1*1 matrix is called as a special matrix.
	- The size of the special matrix should be a square, i.e., P*P.

Your task is to help the students to find the speical matrix  with max size P.


Input Format:
-------------
Line-1: Two space separated integers M and N, size of the matrix.
Next M lines: N space separated integers m and n.

Output Format:
--------------
Print an integer, maximum size P of the special matrix.


Sample Input-1:
---------------
5 5
7 8 3 5 6
3 5 1 6 7
3 5 4 3 1
6 2 7 3 2
5 4 7 6 2

Sample Output-1:
----------------
3

Explanation:
------------
The special square is:
5 1 6
5 4 3
2 7 3


Sample Input-2:
---------------
4 4
7 8 3 5
3 2 1 6
3 2 3 3
6 2 3 3

Sample Output-2:
----------------
2

Explanation:
------------
The special square is:
3 3
3 3
*/


import java.util.*;

public class day41program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        int max = Math.min(m, n);
        for(int k=max; k>=1; k--) {
            for(int i=0; i<=m-k; i++) {
                for(int j=0; j<=n-k; j++) {
                    if(isSpecial(matrix, i, j, k)) {
                        System.out.print(k);
                        return;
                    }
                }
            }
        }
        System.out.print(1);
    }
    
    public static boolean isSpecial(int[][] matrix, int row, int col, int size) {
        int targetSum = 0;
        for(int j=0; j<size; j++) {
            targetSum += matrix[row][col+j];
        }

        for(int i=0; i<size; i++) {
            int rowSum = 0;
            for(int j=0; j<size; j++) {
                rowSum += matrix[row+i][col+j];
            }
            if(rowSum != targetSum){
                return false;   
            }
        }

        for(int j=0; j < size; j++) {
            int colSum = 0;
            for (int i = 0; i < size; i++) {
                colSum += matrix[row + i][col + j];
            }
            if(colSum != targetSum){ 
                return false;
            }
        }

        int diag1=0;
        for(int i = 0; i<size; i++) {
            diag1 += matrix[row + i][col + i];
        }
        if(diag1 != targetSum){ 
            return false;
        }

        int diag2 = 0;
        for(int i=0; i<size; i++) {
            diag2 += matrix[row+i][col+size-1-i];
        }
        if(diag2 != targetSum){ 
            return false;
        }
        return true;
    }
}
