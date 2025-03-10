package leetcode.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class assignCokies {
    public int findContentChildren(int[] g, int[] s) {
        PriorityQueue<Integer> greedQueue = new PriorityQueue<>();

        for (int i : g) {
            greedQueue.add(i);
        }

        Arrays.sort(s);

        int count = 0;
        int index = 0;

        while (!greedQueue.isEmpty() && index < s.length) {
            int minGreed = greedQueue.poll();

            while (index < s.length && s[index] < minGreed) {
                index++;
            }

            if (index < s.length) {
                count++;
                index++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
