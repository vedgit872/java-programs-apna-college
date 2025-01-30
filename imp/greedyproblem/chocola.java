package imp.greedyproblem;
import java.util.*;

public class chocola {
    public static void main(String[] args) {
        Integer x[] = {2, 1, 3, 1, 4}; // Horizontal cut costs
        Integer y[] = {4, 1, 2};       // Vertical cut costs
        
        // Sort in descending order
        Arrays.sort(x, Comparator.reverseOrder());
        Arrays.sort(y, Comparator.reverseOrder());
        
        int h = 0; // Index for vertical cuts
        int v = 0; // Index for horizontal cuts
        int cost = 0; // Total cost
        int horizontalPieces = 1; // Initially 1 vertical piece
        int verticalPieces = 1;   // Initially 1 horizontal piece

        // Process cuts in a greedy manner
        while (h < y.length && v < x.length) {
            if (x[v] >= y[h]) {
                cost += x[v] * horizontalPieces; // Horizontal cut affects all vertical pieces
                verticalPieces++; // Increases vertical pieces
                v++; // Move to the next horizontal cut
            } else {
                cost += y[h] * verticalPieces; // Vertical cut affects all horizontal pieces
                horizontalPieces++; // Increases horizontal pieces
                h++; // Move to the next vertical cut
            }
        }

        // Process remaining horizontal cuts
        while (v < x.length) {
            cost += x[v] * horizontalPieces;
            v++;
        }

        // Process remaining vertical cuts
        while (h < y.length) {
            cost += y[h] * verticalPieces;
            h++;
        }

        // Output the total cost
        System.out.println(cost);
    }
}

