package codility.distancemin;

import java.util.Arrays;

public class Solution {
    public static int  solution(int[] A) {
        int n = A.length;
        if (n == 1)
            return -2;

        Arrays.sort(A);
        int res = Math.abs(A[1] - A[0]);
        for (int i = 2; i < n; i++) {
            res = Math.min(res, Math.abs(A[i] - A[i - 1]));
        }
        if (res > 100_000_000){
            res = -1;
        }

        return res;
    }

    private static int minAdjDifference(int arr[], int n)
    {
        if (n == 1)
            return -1;

        Arrays.sort(arr);
        int res = Math.abs(arr[1] - arr[0]);
        for (int i = 2; i < n; i++)
            res = Math.min(res, Math.abs(arr[i] - arr[i - 1]));


        return res;
    }

    public static void main(String args[]){
        int arr[] = {0,3,3,7,5,3,11,1};
        int arr2[] = {0, 100000001, 900000000};
        int arr3[] = {-2147483648, 0, -2147483646};
        System.out.println("Min Absolute Distance: "+ solution(arr3));
    }
}