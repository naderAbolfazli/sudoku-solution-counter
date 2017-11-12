package ir.maktab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String a;
        int[][] cells = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                a = in.next();
                cells[i][j] = a.equals("x") ? 0 : Integer.parseInt(a);
            }

        System.out.print("solution Number=" + solve(0, 0, cells, 0));
    }

    // returns 0, 1 or more than 1 depending on whether 0, 1 or more than 1 solutions are found
    static int solve(int i, int j, int[][] cells, int count /*initailly called with 0*/) {
        if (i == 3) {
            i = 0;
            if (++j == 3)
                return 1 + count;
        }
        if (cells[i][j] != 0)  // skip filled cells
            return solve(i + 1, j, cells, count);
        // search for n solutions instead of 1
        for (int val = 1; val <= 3; ++val) {
            if (legal(i, j, val, cells)) {
                cells[i][j] = val;
                count = solve(i + 1, j, cells, count);
            }
        }
        cells[i][j] = 0; // reset on backtrack
        return count;
    }

    private static boolean legal(int i, int j, int val, int[][] cells) {
        for (int n = 0; n < 3; n++) {
            if ((cells[i][n] == val && n != j) || (cells[n][j] == val && n != i))
                return false;
        }
        return true;
    }
}
