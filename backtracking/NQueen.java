import java.util.*;


class NQueen {
    public void printBoard(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------------------");
        return;
    }
    public boolean isValid(int currRow, int currCol, int n, char[][] board) {
        // for same column queens, colDiff == 0
        // for diagonals, x+y=i+j or x-i=j-y 
        for(int i=0;i<currRow;i++) {
            for(int j=0;j<n;j++) {
                if((j-currCol == 0 || Math.abs(currRow - i) == Math.abs(currCol-j))  && board[i][j] == 'Q') return false;
            }
        }
        return true;
    }
    public void solve(int currRow, int n, char[][] board) {
        if(currRow == n) {
            printBoard(board);
            return;
        }
        for(int j=0;j<n;j++) {
            board[currRow][j] = 'Q';
            if(isValid(currRow, j, n, board)) solve(currRow+1, n, board);
            board[currRow][j] = '.';
        }
        return;
    }
    public void solveNQueen(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                board[i][j] = '.';
            }
        }
        // printBoard(board);
        solve(0, n, board);
        return;
    }

    public static void main(String[] args) {
        int n = 4;
        NQueen q = new NQueen();
        q.solveNQueen(n);
    }
}