package exersize.module39_trees;

public class largestRegion {
    static int adj[][] = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    public static int region(int arr[][], int r, int c) {
        boolean vis[][] = new boolean[r][c];
        int max = 0;
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis.length; j++) {
                if (arr[i][j] == 1) {
                    int co = regionhelper(arr, vis, i, j);
                    max = max < co ? co : max;
                }
            }
        }
        return max;
    }

    public static int regionhelper(int arr[][], boolean vis[][], int r, int c) {
        if (r < 0 || r >= arr.length || c < 0 || c >= arr[0].length || vis[r][c] || arr[r][c] == 0) {
            return 0;
        }
        vis[r][c] = true;
        int count = 1;
        for (int[] ad : adj) {
            int newRow = r + ad[0];
            int newCol = c + ad[1];

            if (newRow >= 0 && newRow < arr.length && newCol >= 0 && newCol < arr[0].length) {
                count += regionhelper(arr, vis, newRow, newCol);
            }

        }
        return count;
    }

    public static void main(String args[]) {
        int arr[][] = { { 0, 0, 1, 1, 0 }, { 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 } };
        System.out.println(region(arr, arr.length, arr[0].length));
    }
}
