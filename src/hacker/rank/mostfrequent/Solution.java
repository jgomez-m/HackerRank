package hacker.rank.mostfrequent;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        String input = "1, 3, -5, 3, 3, -5, 1, -5, -5, 0, 100, 20, 9, 0, 3, 0, 3, A, F";
        Solution.getTheThreeMost(input);
    }

    public static void getTheThreeMost(String input) {
        // 1. Split String in an List
        // 2. Filter by Numbers
        // 3. Map count numbers
        // 4. Sort by count
        // 5. Choose the first three
        String[] tokens =  input.split(",");
        List<Integer> numList = new ArrayList<>();
        Map<Integer, Integer> mapCount = new HashMap<>();
        for(String elem : tokens){
            try {
                Integer number = Integer.parseInt(elem.trim());
                numList.add(number);
                if(mapCount.containsKey(number)){
                    mapCount.put(number, mapCount.get(number)+1);
                } else{
                    mapCount.put(number, 1);
                }
            }catch (NumberFormatException e) {
                //skip
            }
        }

        Map<Integer, Integer> mapSorted = mapCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        mapSorted.forEach((key, value) -> System.out.println(key));
    }
}
