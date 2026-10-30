class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            boolean [] seen = new boolean[9];
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int d=board[i][j]-'0';
                if(seen[d-1])return false;
                seen[d-1]=true;
            }
        }
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                int d = board[j][i] - '0';
                if (seen[d - 1]) return false;
                seen[d - 1] = true;
            }
        }

        for (int startRow = 0; startRow < 9; startRow += 3) {
        for (int startCol = 0; startCol < 9; startCol += 3) {

        boolean[] seen = new boolean[9];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                char cell = board[startRow + r][startCol + c];
                if (cell == '.') continue;
                int d = cell - '0';
                if (seen[d - 1]) return false;
                seen[d - 1] = true;
            }
        }
    }
}
        return true;
    }
}
