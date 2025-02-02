package imp.priorityQueues_and_heaps.heapProblem;

import java.util.PriorityQueue;

public class weakestSoldier {
    static class soldi implements Comparable<soldi> {
        int count;
        int r;

        soldi(int count, int r) {
            this.count = count;
            this.r = r;
        }

        @Override
        public int compareTo(soldi r1) {
            if (this.count == r1.count) {
                return Integer.compare(this.r, r1.r);  // Sort by row index if count is the same
            }
            return Integer.compare(this.count, r1.count); // Sort by soldier count first
        }
    }

    public static void main(String[] args) {
        PriorityQueue<soldi> s = new PriorityQueue<>();
        int k = 4;
        int a[][] = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 1, 0, 0}
        };

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            count = 0;
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            s.add(new soldi(count, i));
        }

        for (int i = 0; i < k; i++) {
            soldi weakest = s.remove();
            System.out.println(weakest.r + " " + weakest.count);
        }
    }
}
