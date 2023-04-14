package com.example.decrypter.decryption;

import java.io.File;
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
    private int keyLength = 5;

    public Map<Character, Integer> charFrequencyMap = new HashMap<>();
    private ArrayList<HashMap<Character,Integer>> charFrequencyHashMaps = new ArrayList<>();

    protected Decrypter(File input, File output){
        this.input = input;
        this.output = output;
        this.initializeCharFrequencyHashMaps();
    }

    protected Decrypter(File input, File output, int keyLength){
        this(input,output);
        this.keyLength = keyLength;
    }

    abstract public void initializeCharFrequencyHashMaps();

    @Override
    public void extractCharFrequency() throws IOException {
        FrequencyAnalyzer freqAnalyzer = new FrequencyAnalyzer();
        Path filePath = this.input.toPath();
        String fileContent = Files.readString(filePath, StandardCharsets.UTF_8);
        this.charFrequencyMap = freqAnalyzer.analyze(fileContent);
        System.out.println(this.charFrequencyMap);

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

    }
}
