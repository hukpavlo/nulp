package lab1;

import java.util.Random;

abstract class Sort {
  String[] initialArray;
  String[] sortedArray;

  public Sort init(int numberOfWords) {
    Random random = new Random();
    this.initialArray = new String[numberOfWords];

    for (int i = 0; i < numberOfWords; i++) {
      char[] word = new char[random.nextInt(8) + 1];

      for (int j = 0; j < word.length; j++) {
        word[j] = (char) (random.nextBoolean() ? 'a' : 'A' + random.nextInt(26));
      }

      this.initialArray[i] = new String(word);
    }

    this.sortedArray = this.initialArray.clone();

    return this;
  }

  public abstract Sort sort();

  public void printResult() {
    System.out.println("---- Initial array ---");
    this.printArray(this.initialArray);
    System.out.println("---- Sorted array ----");
    this.printArray(this.sortedArray);
    System.out.println("----------------------");
  }

  private void printArray(String[] array) {
    for (String i : array) {
      System.out.println(i);
    }
  }
}
