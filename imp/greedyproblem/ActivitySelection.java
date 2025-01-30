package imp.greedyproblem;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    public static int act(double[][] activities) {
        int count = 1; // First activity is always selected
        int lastSelected = 0; // Index of the last selected activity

        for (int i = 1; i < activities.length; i++) {
            // Compare start time of the current activity with end time of the last selected activity
            if (activities[i][1] >= activities[lastSelected][2]) {
                count++;
                lastSelected = i; // Update the last selected activity
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int sta[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 8, 9, 9};

        // Create a 2D array to store activities with their indices, start, and end times
        double activities[][] = new double[sta.length][3];
        for (int i = 0; i < activities.length; i++) {
            activities[i][0] = i;    // Activity index
            activities[i][1] = sta[i]; // Start time
            activities[i][2] = end[i]; // End time
        }

        // Sort activities based on their end times (column 2)
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // Pass the sorted activities array to the `act` method
        int maxActivities = act(activities);

        // Print the maximum number of non-overlapping activities
        System.out.println("Maximum number of non-overlapping activities: " + maxActivities);
    }
}
