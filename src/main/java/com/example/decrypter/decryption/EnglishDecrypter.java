package com.example.decrypter.decryption;

import java.io.File;

public class EnglishDecrypter extends Decrypter{
    public EnglishDecrypter(File input, File output, File data) {
        super(input, output, data);
    }

    public EnglishDecrypter(File input, File output, File data , int keyLength){
        super(input, output, data, keyLength);
    }

    @Override
    public void initializeCharFrequencyHashMaps(){
        //TODO remove the comments add the getKeyLength
        System.out.println("TEST" + this.getKeyLength());
        for(int i = 0 ; i< this.getKeyLength();i++){
            this.getCharFrequencyHashMaps().add(AlphabetMaps.getEnglishAlphabetMap());
        }
    }
}
