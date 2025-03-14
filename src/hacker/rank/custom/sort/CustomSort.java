package hacker.rank.custom.sort;

/**
 * An array of integers arr, of size n is defined as a[0], a[1], ...., a[n-1]. You will be
 * given an array of integers to sort. Sorting must first be by frequency of occurrence, then
 * by value. For instance, given an array [4, 5, 6, 5, 4, 3], there is one each of 6's and 3's
 * , and there are two 4's, two 5's. The sorted list is [3, 6, 4, 4, 5, 5].
 *
 *  Function Description
 *  complete the function customSort in the editor below. The function must return an array sorted
 *  ascending first by frequency of occurrence, then by value within frequency.
 *
 *  customSort has the following parameter(s).
 *  	arr[arr[0], arr[1], ...., arr[n-1]] : an array of integers to sort
 *
 *  Constraints
 *  1 <= n <= 2*10^5
 *  1 <= arr[i] <= 10^6
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CustomSort {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 4);
        customSort(list);
    }

    static void customSort(List<Integer> list) {
        int[] arr = list.stream().mapToInt(i->i).toArray();
        Map<Integer, Integer> freqMap = createFreqMap(arr);
        List<java.util.Map.Entry<Integer, Integer>> entryList = sortByValue(freqMap);
        printEntryList(entryList);
    }

    static Map<Integer, Integer> createFreqMap(int[] arr){
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if(freqMap.containsKey(key)) {
                freqMap.put(key, freqMap.get(key) + 1);
            }else {
                freqMap.put(key, 1);
            }
        }
        return freqMap;
    }

    private static List<Entry<Integer, Integer>> sortByValue(Map<Integer, Integer> freqMap){

        List<Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());

        Collections.sort(entryList, new Comparator<Entry<Integer, Integer>>() {

            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        return entryList;
    }

    private static void printEntryList(List<Entry<Integer, Integer>> entryList)
    {
        for(Entry<Integer, Integer> entry : entryList) {
            for(int i = 0; i < entry.getValue(); i++) {
                System.out.println(entry.getKey());
            }
        }
        char event = "events".toCharArray();
        Integer.toString()
    }
}