package lab1;

import java.util.Arrays;
import java.util.Comparator;

public class LengthSort extends Sort {
  public static void main(String[] args) {
    new LengthSort().init(10).sort().printResult();
  }

  public LengthSort sort() {
    Arrays.sort(this.sortedArray, Comparator.comparingInt(String::length));

    return this;
  }
}
