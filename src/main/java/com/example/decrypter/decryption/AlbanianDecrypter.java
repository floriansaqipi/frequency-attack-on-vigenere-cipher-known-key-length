package com.example.decrypter.decryption;

import java.io.File;

public class AlbanianDecrypter extends Decrypter{
    public AlbanianDecrypter(File input, File output){
        super(input,output);
    }

    public AlbanianDecrypter(File input, File output, int keyLength){
        super(input,output,keyLength);
    }
    @Override
    public void initializeCharFrequencyHashMaps(){
      //add initialize implementation
    }
}
