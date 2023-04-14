package com.example.decrypter.decryption;

import java.io.IOException;

public interface Analysis {
    void extractCharFrequency() throws IOException;

    void mapCharByFrequency();
    void repeatDecryptionByCol();
    void writeDecryptedTextToFile();
    void performDecryption();
}
