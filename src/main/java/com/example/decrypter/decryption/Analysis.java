package com.example.decrypter.decryption;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface Analysis {
    void extractCharFrequency(File file, ArrayList<HashMap<Character, Integer>> hashMaps);

    void mapCharByFrequency();
    void writeDecryptedTextToFile();
    void performDecryption();
}
