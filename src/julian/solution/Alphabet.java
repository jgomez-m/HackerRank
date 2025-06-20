package julian.solution;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
//    Task is to assign the values 1 to 26 to all the alphabets in an order, like a=1, b=2, c=3, …………. z= 26,
//    and then Input any alphabetical string and calculate the sum of that string?
//    Example:
//    Input: java
//    Output: 34
//    Explanation:
//            (Where j=10, a=1, v=22, a=1)

    static Map<String, Integer> alphabetMap = new HashMap<>();
    public static void main(String[] args) {
        intializeMap();
        int response = Alphabet.convert("java");
        System.out.println("This is the sum of chars: " + response);
    }

    private static int convert(String input) {
        int response = 0;
        String tokens[] = input.split("");
        for (String str : tokens) {
            int value = alphabetMap.get(str);
            response += value;
        }
        return response;
    }

    private static void intializeMap() {
        int character = 97;
        for (int i=1; i<=26; i++){
            alphabetMap.put(Character.toString(character), i);
            character++;
        }
        //System.out.println(alphabetMap);
    }
}
