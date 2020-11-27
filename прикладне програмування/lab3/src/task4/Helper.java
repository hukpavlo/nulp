package task4;

public class Helper extends Thread {
    final int[] array;
    final int index;
    final Manager manager;

    Helper(Manager manager, int index, int[] array) {
        super("Row: " + index);
        this.array = array;
        this.index = index;
        this.manager = manager;
    }

    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int result = 0;

        for (int number: array) {
            result += number;
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());

        manager.addResult(result, this.index);
    }
}
