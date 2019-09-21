class Sudoku {
    public static boolean duplicateInRow(char[][] board, int i, int j, char curr) {
        for (int y=0;y<9;y++){
            if(y == j) continue;
            else if(board[i][y] == curr) return true;
        }
        return false;
    }
    
    public static boolean duplicateInCol(char[][] board, int i, int j, char curr) {
        for(int x=0;x<9;x++){
            if (x == i) continue;
            else if (board[x][j] == curr) return true;
        }
        return false;
    }
    
    public static boolean duplicateInSubGrid(char[][] board, int i, int j, char curr) {
        int xOffset = (i/3)*3;
        int yOffset = (j/3)*3;
        for(int x=xOffset;x<xOffset+3;x++) {
            for (int y=yOffset;y<yOffset+3;y++) {
                if (x == i && y == j) continue;
                else if (curr == board[x][y]) return true;
            }
        }
        return false;
    }
    
    public static boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char curr = board[i][j];
                if (curr == '.') continue;
                if (duplicateInRow(board, i, j, curr) || duplicateInCol(board, i, j, curr) || duplicateInSubGrid(board, i, j, curr)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isValidPlacement(char[][] board, int i, int j, char curr) {
        if (duplicateInCol(board, i, j, curr) || duplicateInRow(board, i, j, curr) || duplicateInSubGrid(board, i, j, curr)){
            return false;
        }
        return true;
    }
    public static boolean solve(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++) {
                if (board[i][j] == '.') {
                    for (char curr='1';curr<='9';curr++) {
                        if (isValidPlacement(board, i, j, curr)) {
                            board[i][j] = curr;
                            if(solve(board)) return true;
                            else board[i][j] = '.';    
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }
}