package advanced;

/**
 * Created by root on 19/12/15.
 */
public class SRotateMatrixBy90Degree {
    public static void main(String[] args) {
        int[][] input = {{01, 02, 03, 04},
                    {11, 12, 13, 14},
            {21, 22, 23, 24},
            {31, 32, 33, 34}};
        rotateMatrix(input);

    }

    public static void rotateMatrix(int[][] input){
        int n = input.length;
        // For n/2 times
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i -first;
                int temp = input[first][i];
                input[first][i] = input[last-offset][first];
                input[last-offset][first] = input[last][last - offset];
                input[last][last - offset] = input[i][last];
                input[i][last] = temp;
            }
        }

        for (int i = 0; i <input.length ; i++) {
            for (int j = 0; j <input[0].length ; j++) {
                System.out.print(input[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
