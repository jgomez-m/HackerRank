package hacker.rank.admios;

import java.util.Arrays;
import java.util.Stack;

class ReverseOdd {


    static void show(int arr[], int n)
    {
        System.out.print("{");

        for(int i = 0; i < n - 1; i++)
            System.out.print(arr[i] + ", ");

        System.out.print(arr[n - 1] + "}");
    }


    public static int[] flipHalf(int arr[], int n)
    {
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++)
        {
            int x = arr[i];

            if (i % 2 == 1)
            {
                st.push(x);
            }
        }


        for(int i = 0; i < n; i++)
        {
            if (i % 2 == 1)
            {
                int x = st.pop();
                arr[i] = x;
            }
        }
        return arr;
    }

    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        int n = arr.length;

        flipHalf(arr, n);
        Arrays.stream(arr).forEach(x-> System.out.print(x + ","));
    }
}