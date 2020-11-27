package task4;

public class Manager {
    int elementsNumber;
    final int[] results;

    Manager(int elementsNumber) {
        this.elementsNumber = elementsNumber;
        this.results = new int[elementsNumber];
    }

    public synchronized void addResult(int result, int index) {
        this.results[index] = result;
        this.elementsNumber--;

        while (elementsNumber != 0) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }

        for (int i = 0; i < results.length; i++) {
            System.out.println("--------------");
            System.out.println("Row " + i + " sum: " + results[i]);
        }
        System.out.println("--------------");
    }
}
