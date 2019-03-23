/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author ammar
 */
//Model Class
public class Grid {

    private MyView v;
    private int grid[][];

    public Grid(MyView v) {
        grid = new int[][]{
            {10, 10, 10},
            {10, 10, 10},
            {10, 10, 10}
        };
        this.v = v;
    }

    public boolean addAt(int rowIndex, int colIndex, int val) {
        boolean result = false;
        if (grid[rowIndex][colIndex] == 10) {
            result = true;
            grid[rowIndex][colIndex] = val;
        }

        return result;
    }

    public void evaluate() {

        Thread t = new Thread(new Runnable() {
            public void run() {

                int lrdiagonal = 0;
                int rldiagonal = 0;
                int rowsum = 0;
                int colsum = 0;
                int x = 0;
                int winner = -1;

                for (int i = 0; i < 3 && winner == -1; ++i) {
                    for (int j = 0; j < 3 && winner == -1; ++j) {

                        rowsum += grid[i][j];
                        colsum += grid[j][i];
                    }

                    if (rowsum == 3 || colsum == 3) {
                        winner = 1;
                    } else if (rowsum == 0 || colsum == 0) {
                        winner = 0;
                    }

                    rowsum = 0;
                    colsum = 0;
                }

                lrdiagonal = grid[0][0] + grid[1][1] + grid[2][2];
                rldiagonal = grid[2][0] + grid[1][1] + grid[0][2];

                if (lrdiagonal == 3 || rldiagonal == 3) {
                    winner = 1;
                } else if (lrdiagonal == 0 || rldiagonal == 0) {
                    winner = 0;
                } else {
                    if (winner == -1) {
                        int countChecked = 0;

                        for (int i = 0; i < 3; ++i) {
                            for (int j = 0; j < 3; ++j) {
                                if (grid[i][j] != 10) {
                                    countChecked++;
                                }
                            }
                        }

                        if (countChecked == 9) {
                            winner = 2;
                        }
                    }
                }
                if (winner >= 0) {
                    v.displayWinner(winner);
                } else {
                    v.switchTurn();
                }

            }

        });
        t.start();
    }

}
