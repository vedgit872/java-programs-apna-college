package imp.priorityQueues_and_heaps.heap;

import java.util.*;

public class heap1 {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int child = arr.size() - 1;
            int parentIdx = (child - 1) / 2;
            while (child > 0 && arr.get(child) < arr.get(parentIdx)) {
                // Swap values
                int temp = arr.get(parentIdx);
                arr.set(parentIdx, arr.get(child));
                arr.set(child, temp);

                // Move up
                child = parentIdx;
                parentIdx = (child - 1) / 2;
            }
        }

        public void Print() {
            int i = 0;
            while (i < arr.size()) {
                System.out.print(arr.get(i) + " ");
                i++;
            }
            System.out.println();
        }

        public int peek() {
            return arr.get(0);
        }

        // Heapify: Restores heap property from given index downwards
        private void heapify(int idx) {
            int smallest = idx;
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;

            // Find the smallest among root, left child, and right child
            if (left < arr.size() && arr.get(left) < arr.get(smallest)) {
                smallest = left;
            }
            if (right < arr.size() && arr.get(right) < arr.get(smallest)) {
                smallest = right;
            }

            // If the smallest is not the root, swap and recurse
            if (smallest != idx) {
                int temp = arr.get(idx);
                arr.set(idx, arr.get(smallest));
                arr.set(smallest, temp);

                // Recursive call for affected subtree
                heapify(smallest);
            }
        }

        // Remove the root element (Min Heap always removes the smallest element)
        public int remove() {
            if (arr.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }

            int minValue = arr.get(0);

            // Move last element to root and remove last element
            arr.set(0, arr.get(arr.size() - 1));
            arr.remove(arr.size() - 1);

            // Restore heap property
            heapify(0);

            return minValue;
        }
    }
    // for max heap
    static class Heapmax {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int child = arr.size() - 1;
            int parentIdx = (child - 1) / 2;
            while (child > 0 && arr.get(child) > arr.get(parentIdx)) {
                // Swap values
                int temp = arr.get(parentIdx);
                arr.set(parentIdx, arr.get(child));
                arr.set(child, temp);

                // Move up
                child = parentIdx;
                parentIdx = (child - 1) / 2;
            }
        }

        public void Print() {
            int i = 0;
            while (i < arr.size()) {
                System.out.print(arr.get(i) + " ");
                i++;
            }
            System.out.println();
        }

        public int peek() {
            return arr.get(0);
        }

        // Heapify: Restores heap property from given index downwards
        private void heapify(int idx) {
            int smallest = idx;
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;

            // Find the smallest among root, left child, and right child
            if (left < arr.size() && arr.get(left) > arr.get(smallest)) {
                smallest = left;
            }
            if (right < arr.size() && arr.get(right) > arr.get(smallest)) {
                smallest = right;
            }

            // If the smallest is not the root, swap and recurse
            if (smallest != idx) {
                int temp = arr.get(idx);
                arr.set(idx, arr.get(smallest));
                arr.set(smallest, temp);

                // Recursive call for affected subtree
                heapify(smallest);
            }
        }

        // Remove the root element (Min Heap always removes the smallest element)
        public int remove() {
            if (arr.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }

            int minValue = arr.get(0);

            // Move last element to root and remove last element
            arr.set(0, arr.get(arr.size() - 1));
            arr.remove(arr.size() - 1);

            // Restore heap property
            heapify(0);

            return minValue;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(10);
        h.add(6);
        h.Print();
        System.out.println(h.peek());
        System.out.println(h.remove());
        System.out.println();
        h.Print();

        // for max heap
        Heapmax h2 = new Heapmax();
        h2.add(2);
        h2.add(3);
        h2.add(4);
        h2.add(5);
        h2.add(10);
        h2.add(6);
        h2.Print();
        System.out.println(h2.peek());
        System.out.println(h2.remove());
        System.out.println();
        h2.Print();

    }
}
