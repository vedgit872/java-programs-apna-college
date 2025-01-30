package imp.backtracking;

public class Sudoku {
    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        // Check column
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }
    
        // Check row
        for (int i = 0; i < sudoku[row].length; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }
    
        // Check 3x3 grid
        int sr = (row / 3) * 3; // Top-left row of the subgrid
        int sc = (col / 3) * 3; // Top-left column of the subgrid
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
    
        return true;
    }
    
    public static boolean SudokuSolver(int[][] sudoku, int row, int col) {
        // Base case: if all rows are done, the Sudoku is solved
        if (row == 9) {
            return true;
        }
    
        // Move to the next row if all columns in the current row are done
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == 9) {
            nextRow++;
            nextCol = 0;
        }
    
        // If the current cell is already filled, skip to the next
        if (sudoku[row][col] != 0) {
            return SudokuSolver(sudoku, nextRow, nextCol);
        }
    
        // Try placing digits 1-9
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
    
                // Recursive call to solve for the next cell
                if (SudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
    
                // Backtrack
                sudoku[row][col] = 0;
            }
        }
    
        return false; // No solution found for this cell
    }  
    // public static boolean isSafe(int[][] sudoku,int row,int col,int digit) {
    //     for (int i = 0; i < sudoku.length; i++) {
    //         if(sudoku[i][col]==digit){
    //             return false;
    //         }
    //     }
    //     for (int i = 0; i < sudoku.length; i++) {
    //         if(sudoku[row][i]==digit){
    //             return false;
    //         }
    //     }
    //     int sr=row/3;
    //     int sc=col/3;
    //     for (int i = sr; i < sr+3; i++) {
    //         for (int j = sc; j < sc+3; j++) {
    //             if (sudoku[i][j]==digit) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    // public static boolean SudokuSolver(int sudoku[][],int row,int col) {
    //     //base case
    //     if(row==9){
    //         return true;
    //     }
    //     //recursion
    //       //row change case
    //     if (col+1==9){
    //         row++;
    //         col=0;
    //     }
    //     //if number already there
    //     if (sudoku[row][col]!=0) {
    //         return SudokuSolver(sudoku, row, col+1);
    //     }
    //     for (int i = 1; i <10; i++) {
    //         if (isSafe(sudoku,row,col,i)) {
    //             sudoku[row][col]=i;
    //             if(SudokuSolver(sudoku, row, col+1))
    //             return true;
    //             sudoku[row][col]=0;                
    //         }
    //     }
    //     return false;
    // }
    public static void main(String[] args) {
        int[][] sudoku= {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println(SudokuSolver(sudoku, 0, 0));
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
}
