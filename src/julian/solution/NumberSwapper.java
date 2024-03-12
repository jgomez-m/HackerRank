package julian.solution;

import java.util.Arrays;

public class NumberSwapper {

    // Given a number, return another number by swapping some or all its digits, the resulting numbers should
    // meet the following conditions:
    // -It must be greater than the original number
    // -It must be the smallest number that meets the first condition
    public static int swapNumber(int number) {
        char[] digits = Integer.toString(number).toCharArray();

        // Find the first digit from the right that is smaller than its right neighbor
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i == -1) {
            // No such digit found, number cannot be increased
            return -1;
        }

        // Find the smallest digit to the right of digits[i] that is greater than digits[i]
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Swap digits[i] and digits[j]
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Sort the digits to the right of digits[i] in ascending order
        //reverse(digits, i + 1, digits.length - 1);
        Arrays.sort(digits, i + 1, digits.length);
        return Integer.parseInt(new String(digits));
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int number = 24935987;
        int swappedNumber = swapNumber(number);

        if (swappedNumber == -1) {
            System.out.println("No greater number can be formed.");
        } else {
            System.out.println("Original number: " + number);
            System.out.println("Swapped number: " + swappedNumber);
        }
    }
}
