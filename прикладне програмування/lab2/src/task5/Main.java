package task5;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[100];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 8);
        }

        System.out.println("Array:");

        for (int item: numbers) {
            System.out.print(item + " ");
        }

        HashSet<Integer> uniqueNumbers = new HashSet<Integer>();

        for (int item: numbers) uniqueNumbers.add(item);

        System.out.println("\nSet:");

        for (int item: uniqueNumbers) {
            System.out.print(item + " ");
        }
    }
}
