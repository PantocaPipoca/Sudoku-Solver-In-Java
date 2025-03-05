import java.util.Scanner;

public class SudokuSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[9][9];
        
        System.out.println("Enter the Sudoku grid row by row (use 0 for empty spaces):");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        
        scanner.close();
        
        SudokuState initialState = new SudokuState(board);
        SudokuState solvedState = SudokuState.backtrackingSearch(initialState);
        
        if (solvedState != null) {
            System.out.println("Solved Sudoku:");
            System.out.println(solvedState);
        } else {
            System.out.println("No solution found for this Sudoku.");
        }
    }
    
}
