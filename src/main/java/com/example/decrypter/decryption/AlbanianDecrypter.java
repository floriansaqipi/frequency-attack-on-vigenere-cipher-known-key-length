package com.example.decrypter.decryption;

import java.io.File;

public class AlbanianDecrypter extends Decrypter{
    public AlbanianDecrypter(File input, File output, File data){
        super(input,output,data);
    }

    public AlbanianDecrypter(File input, File output, File data, int keyLength){
        super(input,output, data ,keyLength);
    }
    @Override
    public void initializeCharFrequencyHashMaps(){
      //TODO add initialize implementation
    }
}
