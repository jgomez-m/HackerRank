package hacker.rank.minmoves;

import java.util.*;

public class Solution {

    // Pair class which will store element of array with its
    // index
    static class Pair {
        int val;
        int idx;
        Pair(int val, int idx)
        {
            this.val = val;
            this.idx = idx;
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int n = 5;
        int[] arr = { 4, 7, 2, 3, 9 };
        System.out.println(minOperations(arr, n));
    }

    // Function to find minimum number of operation required
    // so that array becomes meaningful
    public static int minOperations(int[] arr, int n)
    {
        // Initializing array of Pair type which can be used
        // to sort arr with respect to its values
        Pair[] num = new Pair[n];
        for (int i = 0; i < n; i++) {
            num[i] = new Pair(arr[i], i);
        }

        // Sorting array num on the basis of value
        Arrays.sort(num, (Pair a, Pair b) -> a.val - b.val);

        // Initializing variables used to find maximum
        // length of increasing streak in index
        int res = 1;
        int streak = 1;
        int prev = num[0].idx;
        for (int i = 1; i < n; i++) {
            if (prev < num[i].idx) {
                res++;

                // Updating streak
                streak = Math.max(res, streak);
            }
            else
                res = 1;
            prev = num[i].idx;
        }

        // Returning number of elements left except streak
        return n - streak;
    }
}
