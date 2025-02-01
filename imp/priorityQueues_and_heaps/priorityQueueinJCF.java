package imp.priorityQueues_and_heaps;
import java.util.*;

public class priorityQueueinJCF {
    // ✅ Make Student class static
    public static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(int rank, String name) {
            this.rank = rank;
            this.name = name;
        }

        @Override
        public int compareTo(Student s2) {
            return Integer.compare(this.rank, s2.rank); // Avoid overflow
        }
    }

    public static void main(String[] args) {
        // ✅ Min-Heap Example
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(11);
        pq.add(13);
        pq.add(10);
        pq.add(8);
        pq.add(6);

        System.out.println("Priority Queue (Min-Heap):");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // Use poll() instead of peek() + remove()
        }

        // ✅ Max-Heap Example
        System.out.println("Priority Queue (Max-Heap):");
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        pq1.add(11);
        pq1.add(13);
        pq1.add(10);
        pq1.add(8);
        pq1.add(6);

        while (!pq1.isEmpty()) {
            System.out.println(pq1.poll());
        }

        // ✅ Priority Queue for Students (Min-Heap by rank)
        System.out.println("Priority Queue of Students (by Rank):");
        PriorityQueue<Student> pq2 = new PriorityQueue<>();

        pq2.add(new Student(1, "Vedant1"));
        pq2.add(new Student(3, "Vedant3"));
        pq2.add(new Student(2, "Vedant2"));
        pq2.add(new Student(5, "Vedant5"));
        pq2.add(new Student(8, "Vedant8"));
        pq2.add(new Student(7, "Vedant7"));

        while (!pq2.isEmpty()) {
            Student s = pq2.poll();
            System.out.println(s.name + " " + s.rank);
        }
    }
}
