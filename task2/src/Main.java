import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Ivan Sliusar on 22.08.2018.
 * Red Line Soft corp.
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 4, 0},
                {-2, 1, 3},
                {-1, 0, 1}
        };
        int[] vector = {1, 2, -1};

        System.out.println("Result: " + Arrays.toString(multiplyMatrixToVector(matrix, vector)));
    }

    public static int[] multiplyMatrixToVector(int[][] matrix, int[] vector) {
        int[] result = new int[vector.length];

        IntStream.range(0, result.length)
                .parallel()
                .forEach((i) ->
                        IntStream.range(0, matrix.length)
                                .sequential()
                                .forEach((j) ->result[i] += vector[j] * matrix[i][j])
                );
        return result;
    }

}
