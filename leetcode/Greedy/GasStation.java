package leetcode.Greedy;

/* */

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int currentSurplus = 0;
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int netGain = gas[i] - cost[i];
            totalSurplus += netGain;
            currentSurplus += netGain;

            if (currentSurplus < 0) {
                currentSurplus = 0;
                startingStation = i + 1;
            }
        }

        return totalSurplus >= 0 ? startingStation : -1;
    }

    public static void main(String[] args) {

    }
}
