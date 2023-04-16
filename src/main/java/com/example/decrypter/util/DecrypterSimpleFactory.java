package com.example.decrypter.util;

import com.example.decrypter.decryption.AlbanianDecrypter;
import com.example.decrypter.decryption.Decrypter;
import com.example.decrypter.decryption.EnglishDecrypter;

import java.io.File;

public class DecrypterSimpleFactory {

    private DecrypterSimpleFactory(){}

    public static Decrypter getInstance(File input, File output, File data){
        return  new EnglishDecrypter(input,output,data);
    }

    public static Decrypter getInstance(File input, File output, File data, Language language){
        return switch (language) {
            case ALBANIAN -> new AlbanianDecrypter(input,output, data);
            default ->  new EnglishDecrypter(input,output, data);
        };
    }

    public static Decrypter getInstance(File input, File output, File data ,int keyLength, Language language){
        return switch (language) {
            case ALBANIAN -> new AlbanianDecrypter(input,output, data, keyLength);
            default ->  new EnglishDecrypter(input,output, data ,keyLength);
        };
    }
}
