package lab1;

public class BubbleSort extends Sort {
  public static void main(String[] args) {
    new BubbleSort().init(10).sort().printResult();
  }

  public BubbleSort sort() {
    for (int i = 0; i < this.sortedArray.length - 1; i++) {
      for (int j = 0; j < this.sortedArray.length - i - 1; j++) {
        if (this.sortedArray[j].compareTo(this.sortedArray[j + 1]) > 0) {
          String temp = this.sortedArray[j];
          this.sortedArray[j] = this.sortedArray[j + 1];
          this.sortedArray[j + 1] = temp;
        }
      }
    }

    return this;
  }
}
