import java.util.List;
import java.util.LinkedList;

/**
 * Represents the state of a Sudoku puzzle, including the board configuration and methods for validating moves, generating next states, and solving the puzzle using backtracking search.
 * This class provides functionality to:
 * - Check if the current state is a solution.
 * - Validate if a move follows Sudoku rules.
 * - Generate the next possible state by applying a move.
 * - Generate all valid next states from the current state.
 * - Solve the puzzle using a backtracking search algorithm.
 * @author Daniel Pantyukhov & Valentim Khakhitva
 * @version 1.0 [public]
 */
public class SudokuState {

    private static final int GRID_SIZE = 9;
    private int[][] board;

    /**
     * Constructor for the SudokuState class.
     * @param board The 9x9 board of the Sudoku puzzle.
     */
    public SudokuState(int[][] board)
    {
        this.board = board;
    }

    /**
     * @return The 9x9 board of the Sudoku puzzle.
     */
    public int[][] getBoard()
    {
        return this.board;
    }

    /**
     * Checks if the current state is a solution.
     * @return True if the state is a solution, false otherwise.
     */
    public boolean isSolution() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                int value = board[row][col];
                if (value == 0) return false;
            }
        }
        return true;
    }


    /**
     * Checks if a move is valid according to the Sudoku rules (no repeated values in the same row, column, or 3x3 box).
     * @param row The row of the current move.
     * @param column The column of the current move.
     * @param value The value of the current move.
     * @return True if the move is valid, false otherwise.
     */
    public boolean isValidAction(int row, int column, int value)
    {
        // Check row and column
        for(int i = 0; i < GRID_SIZE; i++){
            if((board[i][column] == value && i != row) || (board[row][i] == value && i != column)) return false;
        }

        // Check box
        // We do this to find the top left corner of the 3x3 box
        // We check if the value is repeated except itself
        int initial_row = row - row % 3;
        int initial_column = column - column % 3;
        for(int i = initial_row; i < initial_row + 3; i++){
            for(int j = initial_column; j < initial_column + 3; j++){
                if((board[i][j] == value && i != row && j != column)) return false;
            }
        }

        return true;
    }


    /**
     * Generates the next state by applying a move to the current state. A state is a 9x9 board configuration at some point in the game.
     * @param row The row of the current move.
     * @param column The column of the current move.
     * @param value The value of the current move.
     * @return The next state after applying the move.
     */
    public SudokuState generateNextState(int row, int column, int value)
    {
        SudokuState nextState = this.clone();
        nextState.board[row][column] = value;
        return nextState;
    }

    /**
     * Generates all valid next states from the current state by applying all possible moves.
     * @return A list of all valid next states.
     */
    public List<SudokuState> generateValidNextStates() 
    {
        List<SudokuState> validStates = new LinkedList<>();
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++){
                if(board[row][column] == 0){
                    for(int i = 1; i <= 9; i++){
                        if(isValidAction(row, column, i)){
                            validStates.add(generateNextState(row, column, i));
                        }
                    }
                    return validStates;
                } 
            }
        }
        return validStates;
    }


    /**
     * Solves the Sudoku puzzle using a backtracking search algorithm.
     * @param initialState The initial state of the Sudoku puzzle.
     * @return The solved state of the Sudoku puzzle.
     */
    public static SudokuState backtrackingSearch(SudokuState initialState)
    {
        // Starts with and empty stack and pushes the initial state
        StackList<SudokuState> stack = new StackList<>();
        stack.push(initialState);

        // While the stack is not empty we keep searching for the solution while popping and pushing states so that the top of the stack is always the most recent state
        while(!stack.isEmpty()) {

            SudokuState currentState = stack.pop();

            if(currentState.isSolution()) return currentState;

            List<SudokuState> validStates = currentState.generateValidNextStates();
            for(SudokuState state: validStates) {

                stack.push(state);

            }

        }

        return null;
    }

    /**
     * Creates a deep copy of the current state.
     * @return A deep copy of the current state.
     */
    public SudokuState clone()
    {
        int[][] newBoard = this.board.clone();

        for(int i = 0; i < GRID_SIZE; i++)
        {
            newBoard[i] = this.board[i].clone();
        }
        SudokuState NextState = new SudokuState(newBoard);

        return NextState;
    }

    public String toString()
    {
        String s = "";
        for(int i = 0 ; i < GRID_SIZE ; i++)
        {
            if(i % 3 == 0)
            {
                s+= "----------------------\n";
            }
            for(int j = 0; j < GRID_SIZE ; j++)
            {
                if(j % 3 == 0)
                {
                    s+= "|";
                }
                if(this.board[i][j] == 0)
                {
                    s+= "_ ";
                }
                else s+= this.board[i][j]+" ";
            }
            s+="|\n";
        }
        s+= "----------------------\n";
        return s;
    }

    public static void main(String[] args) {
        
    }
}
