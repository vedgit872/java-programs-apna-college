package imp.backtracking;

import java.util.Scanner;

public class NqueensTotalCount {
    static int count=0;
    public static void print(int[][]args) {
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args.length; j++) {
                System.out.print(args[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(int[][] args,int row,int col) {
        //vertical
        for (int i = row-1; i >=0; i--) {
            if (args[i][col]==1) {
                return false;
            }
        }
        //right diagonal
        for (int i = row-1,j=col-1; i>=0 && j>=0; i--,j--) {
            if (args[i][j]==1) {
                return false;
            }
        }
        //left diagonal
        for (int i = row-1,j=col+1; i>=0 && j<args.length; i--,j++) {
            if (args[i][j]==1) {
                return false;
            }
        }

        return true;
    }
    public static void NQueens(int[][] board,int row) {
        //base case
        if (row==board.length) {
           count++;
            return;
        }
        //recursive
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board,row,i)) {
                board[row][i]=1;
                NQueens(board, row+1);
                board[row][i]=0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int board[][]=new int[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j]=0;
            }
        }
        NQueens(board,0);
        System.out.println(count);
    }
}


