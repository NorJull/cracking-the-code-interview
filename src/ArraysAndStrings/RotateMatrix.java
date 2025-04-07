package ArraysAndStrings;

/*
* 1.7 Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
*     write a method to rotate the image by 90 degrees. Can you do this in place?
      Hints:#51, #100
* */

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1}
        };
        printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println();
        printMatrix(matrix);

    }

    private static void rotateMatrix(int[][] matrix) {
        int N = matrix.length;
        int numLayers = calculateNumberOfLayers(N);
        int layer = 0;
        int layerSize = N;

        for (int i = 0; i < numLayers; i++) {
            int nSteps = layerSize - 1;
            int row = layer;
            int column = layer;

            Position startingPoint = new Position(layer, layer);

            //Edge of this layer
            Position e1 = new Position(startingPoint.getRow(), nSteps + startingPoint.getColumn());
            Position e2 = new Position(nSteps + startingPoint.getRow(), nSteps + startingPoint.getColumn());
            Position e3 = new Position(nSteps + startingPoint.getRow(),  startingPoint.getColumn());
            Position e4 = new Position(startingPoint.getRow(),  startingPoint.getColumn());

            for (int j = 0; j < nSteps; j++) {
                // First move
                int howMuchLeftToEdge = e1.getColumn() - column;
                int remainingSteps = nSteps - howMuchLeftToEdge;
                int AUX = matrix[startingPoint.getRow() + remainingSteps][e1.getColumn()] ;
                matrix[startingPoint.getRow() + remainingSteps][e1.getColumn()] = matrix[row][column];
                row = startingPoint.getRow() + remainingSteps;
                column = e1.getColumn();

                //Second move
                howMuchLeftToEdge = e2.getRow() - row;
                remainingSteps = nSteps - howMuchLeftToEdge;
                int AUX2 = matrix[e2.getRow()][e2.getColumn() - remainingSteps];
                matrix[e2.getRow()][e2.getColumn() - remainingSteps] = AUX;
                row = e2.getRow();
                column = e2.getColumn() - remainingSteps;

                //Third move
                howMuchLeftToEdge = column - e3.getColumn();
                remainingSteps = nSteps - howMuchLeftToEdge;
                AUX = matrix[e3.getRow() - remainingSteps][e3.getColumn()];
                matrix[e3.getRow() - remainingSteps][e3.getColumn()] = AUX2;
                row = e3.getRow() - remainingSteps;
                column = e3.getRow() - remainingSteps;

                //Fourth move
                howMuchLeftToEdge = row - e4.getRow();
                remainingSteps = nSteps - howMuchLeftToEdge;
                matrix[e4.getRow()] [e4.getColumn() + remainingSteps] = AUX;
                row = e4.getRow();
                column = e4.getColumn() + remainingSteps;
                //Increases column by 1 to move to the next number
                column++;

            }

            // Calculate layerSize
            layerSize = layerSize - 2;
            //move to the next layer
            layer++;
        }
    }

    private static int calculateNumberOfLayers(int length) {
        if( length % 2 == 0)
            return length / 2;
        return (length + 1) / 2;
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

class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}

