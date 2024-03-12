package julian.solution;

import java.util.HashMap;
import java.util.Map;

//Suppose if all the alphabets are assigned values 1 to 26, like a=1, b=2, c=3, …………. z= 26, Input an alphanumeric string and calculate the sum of that string?
//
//        Example:
//        Input: Hello123
//        Output: 58
//        (Where h=8, e=5, l=12, l=12, o=15)
public class AlphabetSum {

    // Map to pre-calculate
    static Map<Character, Integer> alphabetMap = new HashMap<>();

    AlphabetSum() {

    }

    public static void main(String[] args) {
        alphabetMap.put('h', 8);
        alphabetMap.put('e', 5);
        alphabetMap.put('l', 12);
        alphabetMap.put('o', 15);
        // Call the function
        String test = "Hello123";
        int answer = calculateAlphateSum(test);
        System.out.println("Answer  = " + answer);
    }

    private static int calculateAlphateSum(String test) {

        // Check if is character or number
        int sum=0;
        for (int i=0; i<test.length(); i++) {
            if(Character.isLetter(test.charAt(i))) {
                int value = alphabetMap.get((test.toLowerCase().charAt(i)));
                sum += Integer.valueOf(value);
            }
            else if (Character.isDigit(test.charAt(i))) {
                sum += Integer.valueOf(test.charAt(i));
            }
        }
        return sum;
    }

}
