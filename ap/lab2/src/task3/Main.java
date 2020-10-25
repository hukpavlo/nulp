package task3;

public class Main {
    public static void main(String[] args) {
        try {
            Queue<Integer> queue = new Queue<Integer>();

            queue.add(1);
            queue.add(2);
            queue.add(3);

            queue.print();

            queue.delete();

            queue.print();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
