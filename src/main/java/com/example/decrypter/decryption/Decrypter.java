package com.example.decrypter.decryption;

import com.example.decrypter.util.AlphabetMaps;

import java.io.File;
import java.io.FileReader;
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

    @Override
    public void mapCharByFrequency() {

    }

    @Override
    public void repeatDecryptionByCol() {

    }

    @Override
    public void writeDecryptedTextToFile() {

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

