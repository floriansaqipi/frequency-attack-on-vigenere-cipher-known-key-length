package com.example.decrypter.decryption;

import java.io.File;

abstract public class Decrypter implements Analysis{
    private File input;
    private File output;
    private int keyLength = 5;

    protected Decrypter(File input, File output){
        this.input = input;
        this.output = output;
    }

    protected Decrypter(File input, File output, int keyLength){
        this(input,output);
        this.keyLength = keyLength;
    }
}
