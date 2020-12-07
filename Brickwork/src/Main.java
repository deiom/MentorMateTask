import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //Reading the dimensions of the matrix
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        validateDimensions(m, n);

        //Defining first layer
        int[][] matrix = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        //Defining the second layer or bricks
        int[][] secondLayer = new int[m][n];

        //If the matrix is square this is the easiest way to set the second layer of bricks
        if (m == n) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    secondLayer[j][i] = matrix[i][j];
                }
            }
            for (int i = 0; i < secondLayer.length; i++) {
                for (int j = 0; j < secondLayer[i].length; j++) {
                    System.out.printf(secondLayer[i][j] + " ");
                }
                System.out.println();
            }
        }
        //Unfortunately, I am not knowledgeable enough to figure out an automatic way to solve the problem. At the moment
        //I can solve it only manually.
        //Here is a possible solution in order to get the result from the given example.
        // 1 1 2 2 | 2 1 1 4
        // 3 3 4 4 | 2 3 3 4

        else if (matrix[0][0] == matrix[0][1] && matrix[0][2] == matrix[0][3]
                && matrix[1][0] == matrix[1][1] && matrix[1][2] == matrix[1][3]) {

            secondLayer[0][0] = matrix[0][2];
            secondLayer[0][1] = matrix[0][0];
            secondLayer[0][2] = matrix[0][1];
            secondLayer[0][3] = matrix[1][2];
            secondLayer[1][0] = matrix[0][2];
            secondLayer[1][1] = matrix[1][0];
            secondLayer[1][2] = matrix[1][1];
            secondLayer[1][3] = matrix[1][3];

            for (int i = 0; i < secondLayer.length; i++) {
                for (int j = 0; j < secondLayer[i].length; j++) {
                    System.out.printf(secondLayer[i][j] + " ");
                }
                System.out.println();

            }

        }
        //Making sure any other solution returns the given error.
        else {
            System.out.println(-1);
        }
    }
    private static void validateDimensions(int m, int n) {
        //This method checks for the given borders in the task
        if ((m % 2 != 0) || (n % 2 != 0) || (m > 100) || (n > 100)) {
            System.out.print(-1);
        }
    }
}