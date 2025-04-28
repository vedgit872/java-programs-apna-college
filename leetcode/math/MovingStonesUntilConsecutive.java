package leetcode.math;

/*There are three stones in different positions on the X-axis. You are given three integers a, b, and c, the positions of the stones.

In one move, you pick up a stone at an endpoint (i.e., either the lowest or highest position stone), and move it to an unoccupied position between those endpoints. Formally, let's say the stones are currently at positions x, y, and z with x < y < z. You pick up the stone at either position x or position z, and move that stone to an integer position k, with x < k < z and k != y.

The game ends when you cannot make any more moves (i.e., the stones are in three consecutive positions).

Return an integer array answer of length 2 where:

answer[0] is the minimum number of moves you can play, and
answer[1] is the maximum number of moves you can play.
 

Example 1:

Input: a = 1, b = 2, c = 5
Output: [1,2]
Explanation: Move the stone from 5 to 3, or move the stone from 5 to 4 to 3.
Example 2:

Input: a = 4, b = 3, c = 2
Output: [0,0]
Explanation: We cannot make any moves.
Example 3:

Input: a = 3, b = 5, c = 1
Output: [1,2]
Explanation: Move the stone from 1 to 4; or move the stone from 1 to 2 to 4.
  */

public class MovingStonesUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {
        int pos[] = new int[3];
        int answer[] = new int[2];
        int max = 0;
        int min = 0;
        if (a > b && a > c) {
            pos[2] = a;
            if (b > c) {
                pos[1] = b;
                pos[0] = c;
            } else {
                pos[1] = c;
                pos[0] = b;
            }
        }
        if (b > a && b > c) {
            pos[2] = b;
            if (a > c) {
                pos[1] = a;
                pos[0] = c;
            } else {
                pos[1] = c;
                pos[0] = a;
            }
        }
        if (c > a && c > b) {
            pos[2] = c;
            if (a > b) {
                pos[1] = a;
                pos[0] = b;
            } else {
                pos[1] = b;
                pos[0] = a;
            }
        }
        if (pos[0] + 1 == pos[1] && pos[1] + 1 == pos[2]) {
            return answer;
        }
        max = pos[2] - pos[0] - 2;
        if (pos[0] + 1 == pos[1] || pos[0] + 2 == pos[1] || pos[1] + 1 == pos[2] || pos[1] + 2 == pos[2]) {
            min = 1;
        } else {
            min = 2;
        }
        answer[0] = min;
        answer[1] = max;
        return answer;
    }

    public static void main(String[] args) {

    }
}
