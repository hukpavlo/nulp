package lab1;

public class MatrixTransposition {
  public static void main(String[] args) {
    new MatrixTransposition().init();
  }

  public void init() {
    int[][] matrix = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12},
            {13, 14, 15}
    };

    int[][] result = new int[matrix[0].length][matrix.length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        result[j][i] = matrix[i][j];
      }
    }

    System.out.println("--- Before ---");
    printMatrix(matrix);
    System.out.println("--- After ----");
    printMatrix(result);
    System.out.println("--------------");
  }

  private void printMatrix(int[][] matrix) {
    for (int[] arr : matrix) {
      String line = "";

      for (int item : arr) {
        line += item + " ";
      }

      System.out.println(line);
    }
  }
}
