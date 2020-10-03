package lab1;

import java.util.Arrays;
import java.util.Comparator;

public class BigLettersNumberSort extends Sort {
  public static void main(String[] args) {
    new BigLettersNumberSort().init(10).sort().printResult();
  }

  public BigLettersNumberSort sort() {
    Arrays.sort(this.sortedArray, Comparator.comparingInt(this::getBigLettersNumber));

    return this;
  }

  private int getBigLettersNumber(String word) {
    int bigLettersCount = 0;

    for (int i = 0; i < word.length(); i++) {
      if (Character.isUpperCase(word.charAt(i))) {
        bigLettersCount++;
      }
    }

    return bigLettersCount;
  }
}
