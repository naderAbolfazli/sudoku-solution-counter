package ir.maktab;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Random rand = new Random(3);
        String a;
        int[][] cells = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                a = in.next();
                cells[i][j] = a.equals("x") ? 0 : Integer.parseInt(a);
            }

        //for (int i=0; i<3; i++)
        //for (int j=0; j<3; j++){
        //if (arr[i][j]==0){
        int soulutionCount = 0;
        solve(0, 0, cells, soulutionCount);
    }

    // returns 0, 1 or more than 1 depending on whether 0, 1 or more than 1 solutions are found
    static int solve(int i, int j, int[][] cells, int count /*initailly called with 0*/) {
        if (i == 9) {
            i = 0;
            if (++j == 9)
                return 1 + count;
        }
        if (cells[i][j] != 0)  // skip filled cells
            return solve(i + 1, j, cells, count);
        // search for 2 solutions instead of 1
        // break, if 2 solutions are found
        for (int val = 1; val <= 9 && count < 2; ++val) {
            if (legal(i, j, val, cells)) {
                cells[i][j] = val;
                // add additional solutions
                count = solve(i + 1, j, cells, count);
            }
        }
        cells[i][j] = 0; // reset on backtrack
        return count;
    }

    private static boolean legal(int i, int j, int val, int[][] cells) {
        return false;
    }
}
