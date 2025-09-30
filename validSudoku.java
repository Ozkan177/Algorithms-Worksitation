public class validSudoku {
    
}


class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] squares=new int[9];
        int[] row = new int[9];
        int[] col =new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;

                int value = board[i][j] - '1';
                
                if ((row[i] & (1 << value)) > 0 || (col[j] & (1 << value)) > 0 ||
                    (squares[(i / 3) * 3 + (j / 3)] & (1 << value)) > 0) {
                    return false;
                }

                row[i] |= (1 << value);
                col[j] |= (1 << value);
                squares[(i / 3) * 3 + (j / 3)] |= (1 << value);
            }
        }

        
        
        
        
        return true;
        
    }
}