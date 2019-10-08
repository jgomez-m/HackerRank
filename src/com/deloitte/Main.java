package com.deloitte;

import static java.util.stream.Collectors.toMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException
    {
        /*InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        Map<String, Integer> wordsMap = new HashMap<>();
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            if((line = in.readLine()) != null && !line.isEmpty()){
                line = line.trim();
                wordsMap.put(line, line.length());
            }
        }*/
        Map<String, Integer> wordsMap = new HashMap<>();
        wordsMap.put("Hola Mundo", "Hola Mundo".length());
        wordsMap.put("Hello World", "Hello World".length());
        wordsMap.put("Hola", "Hola".length());
        wordsMap.put("Como esta", "Como esta".length());


        Map<String, Integer> sortedMap = wordsMap
            .entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .limit(4)
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                    LinkedHashMap::new));
        System.out.println(sortedMap);
    }
}
