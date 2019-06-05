package hacker.rank.deltaencoding;

import java.util.ArrayList;
import java.util.List;

public class Result {

    /*
     * Complete the 'delta_encode' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY numbers as parameter.
     */

    public static List<Integer> delta_encode(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>(numbers.size());
        for(int i=0; i<numbers.size(); i++){
            if(i==0){
                result.add(numbers.get(0));
            }
            else {
                Integer difference = numbers.get(i) - numbers.get(i-1);

                if (difference < -127 || difference > 127) {
                    result.add(-128);
                }
                result.add(difference);
            }
        }
        return result;
    }

}