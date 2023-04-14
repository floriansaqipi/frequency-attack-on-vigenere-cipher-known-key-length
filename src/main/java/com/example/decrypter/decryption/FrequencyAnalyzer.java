package com.example.decrypter.decryption;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyAnalyzer {

    public Map<Character, Integer> charFrequencyMap = new HashMap<>();
    public Map<Character, Integer> analyze(String inData) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        charFrequencyMap = countOccurrenceOfChar(inData);
        return sortByValue(charFrequencyMap);

    }

    private Map<Character, Integer> countOccurrenceOfChar(String inData) {

        Map<Character, Integer> resultMap= new HashMap<>();

        for(Character element : inData.toCharArray()) {
            if(resultMap.containsKey(element)) {
                int count = resultMap.get(element);
                resultMap.put(element,++count);
            }
            else{
                resultMap.put(element,1);
            }
        }
        return resultMap;
    }
    private Map<Character, Integer> sortByValue(Map<Character, Integer> inMap) {
        return inMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

}
