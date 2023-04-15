package com.example.decrypter.util;

import java.util.HashMap;

public class AlphabetMaps {

    public static HashMap<Character, Integer> getEnglishAlphabetMap(){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i<Alphabet.englishAlphabet.length(); i++){
            hashMap.put(Alphabet.englishAlphabet.charAt(i),0);
        }
        return hashMap;
    }
    public static HashMap<Character, Integer> getAlbanianAlphabetMap(){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i<Alphabet.albanianAlphabet.length(); i++){
            hashMap.put(Alphabet.albanianAlphabet.charAt(i),0);
        }
        return hashMap;
    }
}
