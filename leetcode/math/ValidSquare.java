package leetcode.math;
import java.util.*;

/*Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.

The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.

A valid square has four equal sides with positive length and four equal angles (90-degree angles).

 

Example 1:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: true
Example 2:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
Output: false
Example 3:

Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
Output: true */

public class ValidSquare {
        public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            int[][] points = {p1, p2, p3, p4};
            List<Integer> distances = new ArrayList<>();
    
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    distances.add(distanceSquared(points[i], points[j]));
                }
            }
    
            // Sort the 6 distances
            Collections.sort(distances);
    
            // Conditions:
            // 4 sides: distances[0] to distances[3]
            // 2 diagonals: distances[4] and distances[5]
            return distances.get(0) > 0 &&
                   distances.get(0).equals(distances.get(1)) &&
                   distances.get(1).equals(distances.get(2)) &&
                   distances.get(2).equals(distances.get(3)) &&
                   distances.get(4).equals(distances.get(5)) &&
                   distances.get(4) == 2 * distances.get(0);
        }
    
        private static int distanceSquared(int[] a, int[] b) {
            int dx = a[0] - b[0];
            int dy = a[1] - b[1];
            return dx * dx + dy * dy;
        }
    public static void main(String[] args) {
        
    }
}
