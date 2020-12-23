package hacker.rank.mostfrequent;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        String input = "1, 3, -5, 3, 3, -5, 1, -5, -5, 0, 100, 20, 9, 0, 3, 0, 3, A, F";
        Map<?,?> map1 = getTheThreeMost(input);
        Map<?,?> map2 = getTheThreeMostStreams(input);
        map1.forEach((key, value) -> System.out.println(key +"->"+ value));
        map2.forEach((key, value) -> System.out.println(key +"->"+ value));
    }

    public static Map<?,?> getTheThreeMostStreams(String input){
        String[] tokens = input.split(",");
        Map<String, Long> mapSorted = Arrays.stream(tokens)
                .map(String::trim)
                .filter(Solution::isNumber)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return mapSorted;
    }

    private static boolean isNumber(String str){
        try{
            Integer.valueOf(str);
            return true;
        }catch (NumberFormatException ignored){

        }
        return false;
    }

    public static Map<?,?> getTheThreeMost(String input) {
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
                mapCount.computeIfPresent(number, (k,v) -> v+1);
                mapCount.putIfAbsent(number, 1);
            }catch (NumberFormatException e) {
                //skip
            }
        }

        Map<Integer, Integer> mapSorted = mapCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return mapSorted;
    }
}
