class Solution {
    @SuppressWarnings("unchecked")
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Boolean>[] rows = new Map[9];
        Map<Character, Boolean>[] cols = new Map[9];
        Map<Character, Boolean>[] boxes = new Map[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char digit = board[r][c];

                if (digit == '.') {
                    continue;
                }

                int box = (r / 3) * 3 + (c / 3);

                if (rows[r].put(digit, true) != null
                        || cols[c].put(digit, true) != null
                        || boxes[box].put(digit, true) != null) {
                    return false;
                }
            }
        }

        return true;
    }
}