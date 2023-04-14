package com.example.decrypter.decryption;

import java.io.File;

public class EnglishDecrypter extends Decrypter{
    public EnglishDecrypter(File input, File output) {
        super(input, output);
    }

    public EnglishDecrypter(File input, File output, int keyLength){
        super(input,output,keyLength);
    }

    @Override
    public void initializeCharFrequencyHashMaps(){
        System.out.println("TEST" + this.getKeyLength());
        for(int i = 0 ; i< this.getKeyLength();i++){
            this.getCharFrequencyHashMaps().add(AlphabetMaps.getEnglishAlphabetMap());
        }
    }
}
