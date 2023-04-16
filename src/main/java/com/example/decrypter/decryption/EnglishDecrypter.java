package com.example.decrypter.decryption;

import com.example.decrypter.util.AlphabetMaps;

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
        for (int i = 0; i < this.getKeyLength(); i++) {
            this.getCharFrequencyInputHashMaps().add(AlphabetMaps.getEnglishAlphabetMap());
            this.getCharFrequencyDataHashMaps().add(AlphabetMaps.getEnglishAlphabetMap());
        }
    }
}
