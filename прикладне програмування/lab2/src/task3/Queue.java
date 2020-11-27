package task3;

public class Queue<T> {
    private Node tail;

    private class Node {
        final T value;
        Node next;
        final Node prev;

        Node(T value) {
            this(value, null, null);
        }

        Node(T value, Node next) {
            this(value, next, null);
        }


        Node(T value, Node next, Node prev) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }

    public void add(T item) {
        tail = new Node(item, tail);
    }

    public void delete() throws Exception {
        if (tail == null) {
            throw new Exception("Queue is empty");
        }

        Node curr = tail;
        Node prev = null;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        if (prev != null) {
            prev.next = null;
        } else {
            tail = null;
        }
    }

    public void print() {
        System.out.print("Tail ");

        if (tail == null) return;

        Node temp = tail;

        do {
            System.out.print(temp.value + " ");
            temp = temp.next;
        } while (temp != null);

        System.out.println();
    }
}
