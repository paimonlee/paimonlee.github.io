package com.code.java.practise.package1;

/**
 * Function introduction: 37题解数独.
 * 直觉采用深度递归+剪枝的方法，使用行列压缩，
 * 只是判断是否可以填充的方法不一样
 * Writer: liyunfeng
 * Writing time: 2022-03-18 19:39:16
 */
public class Question37OtherVersion {
    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][] box = new boolean[9][9];

    public static void main(String[] args) {
        Question37 v = new Question37();
        char[][] board =
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        v.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int indexOfBox = i / 3 * 3 + j / 3;
                    line[i][num] = true;
                    column[j][num] = true;
                    box[indexOfBox][num] = true;
                }
            }
        }
        sudo(0, 0, board);
    }

    public boolean sudo(int lastLine, int lastColumn, char[][] board) {
        //从上一次的行列开始找空位
        while (board[lastLine][lastColumn] != '.') {
            if (++lastColumn >= 9) {
                lastLine++;
                lastColumn = 0;
            }
            //如果lastLine等于9说明所有的位置都没有空位了
            if (lastLine >= 9) {
                return true;
            }
        }
        //遍历1-9去选择一个合适的数字
        for (int num = 0; num < 9; num++) {
            char wantChar = (char) (num + '1');
//            if (isLegal(board, lastLine, lastColumn, wantChar)) {
            int indexOfBox = lastLine / 3 * 3 + lastColumn / 3;
            if (!line[lastLine][num] && !column[lastColumn][num] && !box[indexOfBox][num]) {
                line[lastLine][num] = true;
                column[lastColumn][num] = true;
                box[indexOfBox][num] = true;
                board[lastLine][lastColumn] = wantChar;
                if (sudo(lastLine, lastColumn, board)) {
                    return true;
                } else {
                    //剪枝
                    board[lastLine][lastColumn] = '.';
                    line[lastLine][num] = false;
                    column[lastColumn][num] = false;
                    box[indexOfBox][num] = false;
                }
            }
        }
        return false;
    }

    public boolean isLegal(char[][] board, int indexOfLine, int indexOfColumn, char num) {
        if (board[indexOfLine][indexOfColumn] != '.') {
            return false;
        }
        //数独有三成三个大格子
        //先确定在哪个格子里面
        int boxOfLine = indexOfLine / 3;
        int boxOfColumn = indexOfColumn / 3;
        for (int i = boxOfLine * 3; i < (boxOfLine + 1) * 3; i++) {
            for (int j = boxOfColumn * 3; j < (boxOfColumn + 1) * 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        //查看该行
        for (int column = 0; column < 9; column++) {
            if (board[indexOfLine][column] == num) {
                return false;
            }
        }
        //查看该列
        for (int line = 0; line < 9; line++) {
            if (board[line][indexOfColumn] == num) {
                return false;
            }
        }
        return true;
    }
}
