package com.example.decrypter.decryption;

public interface Analysis {
    void extractCharFrequency();

    void mapCharByFrequency();
    void repeatDecryptionByCol();
    void writeDecryptedTextToFile();
    void performDecryption();
}
