package com.example.decrypter.util;

import com.example.decrypter.decryption.AlbanianDecrypter;
import com.example.decrypter.decryption.Decrypter;
import com.example.decrypter.decryption.EnglishDecrypter;

import java.io.File;

public class DecrypterSimpleFactory {

    private DecrypterSimpleFactory(){}

    public static Decrypter getInstance(File input, File output, Language language){
        return switch (language) {
            case ALBANIAN -> new AlbanianDecrypter(input,output);
            default ->  new EnglishDecrypter(input,output);
        };
    }

    public static Decrypter getInstance(File input, File output, int keyLength, Language language){
        return switch (language) {
            case ALBANIAN -> new AlbanianDecrypter(input,output,keyLength);
            default ->  new EnglishDecrypter(input,output,keyLength);
        };
    }
}
