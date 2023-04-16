package com.example.decrypter.decryption;

import com.example.decrypter.util.AlphabetMaps;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

abstract public class Decrypter implements Analysis{
    private File input;
    private File output;

    private File data;
    private int keyLength = 5;

    private ArrayList<LinkedHashMap<Character,Integer>> sortedCharFrequencyDataMaps = new ArrayList<>();
    private ArrayList<LinkedHashMap<Character,Integer>> sortedCharFrequencyInputMaps = new ArrayList<>();

    private ArrayList<HashMap<Character,Integer>> charFrequencyDataHashMaps = new ArrayList<>();

    private ArrayList<HashMap<Character,Integer>> charFrequencyInputHashMaps = new ArrayList<>();

    private ArrayList<String> frequencyDataStrings = new ArrayList<>();
    private ArrayList<HashMap<Character,Character>> frequencyMappedHashMaps = new ArrayList<>();
    protected Decrypter(File input, File output, File data){
        this.input = input;
        this.output = output;
        this.data = data;
        this.initializeCharFrequencyHashMaps();
    }

    protected Decrypter(File input, File output, File data, int keyLength){
        this(input,output,data);
        this.keyLength = keyLength;
    }

    abstract public void initializeCharFrequencyHashMaps();
    
    private void initializeFrequencyMappedHashMaps(){
        for(int i = 0;i < this.keyLength; i++){
            this.frequencyMappedHashMaps.add(new HashMap<Character,Character>());
        }
    }

    private void initializeSortedCharFrequencyMaps(){
        for(HashMap<Character,Integer> hashMap : this.charFrequencyInputHashMaps){
            LinkedHashMap<Character,Integer> linkedHashMap = AlphabetMaps.getValueSortedLinkedHashMap(hashMap);
            this.sortedCharFrequencyInputMaps.add(linkedHashMap);
        }
        for(HashMap<Character,Integer> hashMap: this.charFrequencyDataHashMaps){
            LinkedHashMap<Character,Integer> linkedMap = AlphabetMaps.getValueSortedLinkedHashMap(hashMap);
            this.sortedCharFrequencyDataMaps.add(linkedMap);
        }
    }

    @Override
    public void extractCharFrequency(File file, ArrayList<HashMap<Character,Integer>> hashMaps) {
        try{
            FileReader fileReader = new FileReader(file.getPath());
            int character; int currentCount; char currentChar;
            for(int i = 0; (character = fileReader.read()) != -1; i = (i + 1) % this.keyLength){
                currentChar = (char) character;
                if(!Character.isAlphabetic(currentChar)){
                    i--;
                    continue;
                }
                currentCount = hashMaps.get(i).get(Character.toUpperCase(currentChar));
                hashMaps.get(i).put(Character.toUpperCase(currentChar), currentCount + 1);
            }
            fileReader.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private void extractFrequenciesToStrings(){
        this.initializeSortedCharFrequencyMaps();
        String freqAlphabet = "";
        for(HashMap<Character,Integer> hashMap : this.sortedCharFrequencyDataMaps){
            for(Map.Entry<Character,Integer> entry : hashMap.entrySet()){
                freqAlphabet += entry.getKey();
            }
            this.frequencyDataStrings.add(freqAlphabet);
            freqAlphabet = "";
        }
    }



    @Override
    public void mapCharByFrequency() {
        int i  = 0, j = 0;
        String currentAlphabetFreq;
        for(HashMap<Character,Integer> hashMap : this.sortedCharFrequencyInputMaps){
            j = 0;
            currentAlphabetFreq = this.frequencyDataStrings.get(i);
            for(Map.Entry<Character,Integer> entry: hashMap.entrySet()){
                this.frequencyMappedHashMaps.get(i).put(entry.getKey(),currentAlphabetFreq.charAt(j));
                j++;
            }
            i++;
        }
    }

    @Override
    public void writeDecryptedTextToFile() {
        try{
            FileReader fileReader = new FileReader(this.input.getPath());
            FileWriter fileWriter = new FileWriter(this.output);
            int character, currentCount; char charToWrite, currentChar;
            for(int i = 0; (character = fileReader.read()) != -1; i = (i + 1) % this.keyLength){
                currentChar = (char) character;
                if(!Character.isAlphabetic(currentChar)){
                    i--;
                    continue;
                }
                charToWrite = this.frequencyMappedHashMaps.get(i).get(Character.toUpperCase(currentChar));
                fileWriter.write(charToWrite);
            }
            fileReader.close(); fileWriter.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void printFreqHashMaps(){
        int i = 0;
        for(HashMap<Character,Integer> hashMap: this.charFrequencyInputHashMaps){
            System.out.printf("================================================= Key Column : %d =================================================\n",++i);
            System.out.println(hashMap);
        }
    }

    @Override
    public void performDecryption() {
        extractCharFrequency(this.input,this.charFrequencyDataHashMaps);
    }
    public int getKeyLength(){
        return this.keyLength;
    }

    public ArrayList<HashMap<Character, Integer>> getCharFrequencyInputHashMaps(){
        return this.charFrequencyInputHashMaps;
    }
    public ArrayList<HashMap<Character, Integer>> getCharFrequencyDataHashMaps(){
        return this.charFrequencyDataHashMaps;
    }
}

