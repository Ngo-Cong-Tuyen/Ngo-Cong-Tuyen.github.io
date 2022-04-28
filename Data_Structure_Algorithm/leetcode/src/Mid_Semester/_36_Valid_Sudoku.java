package Mid_Semester;

public class _36_Valid_Sudoku {
    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'}
                    ,{'6','.','.','1','9','5','.','.','.'}
                    ,{'.','9','8','.','.','.','.','6','.'}
                    ,{'8','.','.','.','6','.','.','.','3'}
                    ,{'4','.','.','8','.','3','.','.','1'}
                    ,{'7','.','.','.','2','.','.','.','6'}
                    ,{'.','6','.','9','.','.','2','8','.'}
                    ,{'.','.','.','4','1','9','.','.','5'}
                    ,{'.','.','.','.','8','.','.','7','9'}};

//        [[".",".",".",".",".",".","5",".","."],
//        [".",".",".",".",".",".",".",".","."],
//        [".",".",".",".",".",".",".",".","."],
//        ["9","3",".",".","2",".","4",".","."],
//        [".",".","7",".",".",".","3",".","."],
//        [".",".",".",".",".",".",".",".","."],
//        [".",".",".","3","4",".",".",".","."],
//        [".",".",".",".",".","3",".",".","."],
//        [".",".",".",".",".","5","2",".","."]]
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int j=0;j<9;j++){
            if (!checkRow(board,j)) return false;
        }

        for (int i=0;i<9;i++){
            if (!checkColumn(board,i)) return false;
        }
        int j=0;
        while (j<=6){
            int i=0;
            while (i<=6){
                if (!checkSub(board,i,j)) return false;
                i=i+3;
            }
            j=j+3;
        }
        return true;
    }

    public static boolean checkRow(char[][] board,int j) {
        int [] arr= new int[60];
        for (int i=0; i<9;i++){
            if (board[i][j]!='.'){
                arr[board[i][j]]++;
                if (arr[board[i][j]]>1) return false;
            }
        }
        return true;
    }

    public static boolean checkColumn(char[][] board,int i) {
        int [] arr= new int[60];
        for (int j=0; j<9;j++){
            if (board[i][j]!='.'){
                arr[board[i][j]]++;
                if (arr[board[i][j]]>1) return false;
            }
        }
        return true;
    }

    public static boolean checkSub(char[][] board,int i, int j) {
        int [] arr= new int[60];
        for ( int k=j;k<j+3;k++){
            for (int h=i;h<i+3;h++) {
                if (board[h][k] != '.') {
                    arr[board[h][k]]++;
                    if (arr[board[h][k]] > 1) return false;
                }
            }
        }
        return true;
    }
}
