package com.example.decrypter.decryption;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract public class Decrypter implements Analysis{
    private File input;
    private File output;

    private File data;
    private int keyLength = 5;

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

    //TODO improve method for getting by stream and by cols
//    @Override
//    public void extractCharFrequency() throws IOException {
//        FrequencyAnalyzer freqAnalyzer = new FrequencyAnalyzer();
//        Path filePath = this.input.toPath();
//        String fileContent = Files.readString(filePath, StandardCharsets.UTF_8);
//        this.charFrequencyMap = freqAnalyzer.analyze(fileContent);
//        System.out.println(this.charFrequencyMap);
//
//    }

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
}
