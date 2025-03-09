package leetcode.Greedy;

import java.util.*;

public class longestPalindrome {
    static class ch implements Comparable<ch> {
        char ch;
        int freq;

        ch(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        @Override
        public int compareTo(ch c1) {
            return c1.freq - this.freq;
        }
    }

    public int longestPalindrome1(String s) {
        PriorityQueue<ch> q = new PriorityQueue<>(Collections.reverseOrder());

        int[] freq = new int[128];
        for (char a : s.toCharArray()) {
            freq[a]++;
        }

        for (int i = 0; i < 128; i++) {
            if (freq[i] > 0) {
                q.add(new ch((char) i, freq[i]));
            }
        }

        int tot = 0;
        int odd = 0;

        while (!q.isEmpty()) {
            ch tri = q.remove();
            if (tri.freq % 2 == 0) {
                tot += tri.freq;
            } else {
                if (odd == 0) {
                    tot += tri.freq;
                    odd = 1;
                } else {
                    tot += tri.freq - 1;
                }
            }
        }
        return tot;
    }

    public static void main(String[] args) {

    }
}
