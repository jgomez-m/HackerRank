package julian.solution;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyCounter {

    public static void main(String[] args) {
        // Example array of integers
        int[] numbers = {1, 2, 2, 3, 4, 4, 4, 5, 5, 5, 5};
        // Example array of characters
        char[] characters = {'a', 'b', 'a', 'c', 'b', 'd', 'a'};

        // Call the function to count frequency and print results
        countFrequency(numbers);
        countFrequency(characters);
    }

    public static void countFrequency(int[] numbers) {
        // Use Streams to count the frequency of each number
        Map<Integer, Long> frequencyMap = Arrays.stream(numbers)
                .boxed() // Convert int to Integer
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        // Print each number along with its frequency
        frequencyMap.forEach((number, frequency) ->
                System.out.println(number + " appears " + frequency + " time(s)."));
    }

    public static void countFrequency(char[] characters) {
        // Use Streams to count the frequency of each character
        Map<Character, Long> frequencyMap = new String(characters) // Convert char[] to String
                .chars() // Get an IntStream of character codes
                .mapToObj(c -> (char) c) // Convert int codes back to Character
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())); // Group and count

        // Print each character along with its frequency
        frequencyMap.forEach((character, frequency) ->
                System.out.println("Character '" + character + "' appears " + frequency + " time(s)."));
    }
}
