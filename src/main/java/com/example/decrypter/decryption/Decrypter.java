package com.example.decrypter.decryption;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

abstract public class Decrypter implements Analysis{
    private File input;
    private File output;
    private int keyLength = 5;
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
    public void extractCharFrequency() {

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
