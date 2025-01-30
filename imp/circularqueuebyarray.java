package imp;

public class circularqueuebyarray {
    static class Queue {
        static int[] arr;
        static int size;
        static int last;
        static int first;

        Queue(int n) {
            arr = new int[n];
            size = n;
            last = -1;
            first = -1;
        }

        public static boolean isEmpty() {
            return last == -1 && first == -1;
        }

        public static boolean isFull() {
            return (last + 1) % size == first;
        }

        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (first == -1) { // Initialize first on first add
                first = 0;
            }
            last = (last + 1) % size;
            arr[last] = data;
        }

        public static int delete() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int res = arr[first]; // Save the element to be deleted
            if (last == first) {  // If the queue is now empty
                last = -1;
                first = -1;
            } else {
                first = (first + 1) % size;
            }
            return res;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[first];  // Return the front element
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(20);
        q.add(30);
        q.add(40);
        System.out.println(q.peek()); // Expected output: 20
        q.delete();
        System.out.println(q.peek()); // Expected output: 30
        q.add(40);
        q.delete();
        System.out.println(q.peek()); // Expected output: 40
        q.delete();
        System.out.println(q.peek()); // Expected output: Queue is empty
    }
}
