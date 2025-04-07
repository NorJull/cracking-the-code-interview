package ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
*1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
Hints:#17, #74, #702
* */
public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {4,0,6,6},
                {7,8,9,7}};
        zeroMatrix(matrix);

        printMatrix(matrix);

    }
    private static void zeroMatrix(int[][] matrix) {
        Set<Integer> columns = new HashSet<>();
        int N = matrix.length;
        int M = matrix[0].length;
        boolean whereWasOneZero = false;

        for(int i = 0; i < N; i++) {
            whereWasOneZero = false;
            for (int j = 0; j < M; j++) {
                if(matrix[i][j] == 0) {
                    columns.add(j);
                    whereWasOneZero = true;
                }
                if(j == M - 1 && whereWasOneZero) {
                    matrix[i] = new int[matrix[i].length];
                }
            }

        }

        // Fill in columns
        for(int column : columns) {
            for (int j = 0; j < N; j++) {
                matrix[j][column] = 0;
            }
        }
    }

    private  static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println(); // Move to the next line after printing a row
        }
    }
}
