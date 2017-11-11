package ir.maktab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String a;
        int[][] arr= new int[3][3];
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++) {
                a = in.next();
                arr[i][j] = a.equals("x") ? 0 : Integer.parseInt(a);
            }
    }
}
