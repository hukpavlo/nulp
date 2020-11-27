package task4;

public class Main {
    public static void main(String[] args) {
        System.out.printf("%s started... \n", Thread.currentThread().getName());

        int[][] matrix = new int[][]{
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 },
        };

        Manager manager = new Manager(matrix.length);

        for (int i = 0; i < matrix.length; i++) {
            new Helper(manager, i, matrix[i]).start();
        }
    }
}
