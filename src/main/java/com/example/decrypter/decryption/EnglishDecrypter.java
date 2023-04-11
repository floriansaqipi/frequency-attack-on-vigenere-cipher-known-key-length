package com.example.decrypter.decryption;

import java.io.File;

public class EnglishDecrypter extends Decrypter{
    public EnglishDecrypter(File input, File output) {
        super(input, output);
    }

    public EnglishDecrypter(File input, File output, int keyLength){
        super(input,output,keyLength);
    }
}
