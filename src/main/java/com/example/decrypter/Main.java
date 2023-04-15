package com.example.decrypter;

import com.example.decrypter.decryption.Decrypter;
import com.example.decrypter.util.DecrypterSimpleFactory;
import com.example.decrypter.util.Language;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        File inputEnglish =  new File("src/main/java/com/example/decrypter/files/input.txt");
        File dataEnglish = new File("src/main/java/com/example/decrypter/files/data.txt");

        File inputAlbanian =  new File("src/main/java/com/example/decrypter/files/input.txt");
        File dataAlbanian = new File("src/main/java/com/example/decrypter/files/data.txt");

        File output = new File("src/main/java/com/example/decrypter/files/output.txt");

        Decrypter decrypter = DecrypterSimpleFactory.getInstance(dataEnglish,output, dataEnglish , 5 ,Language.ENGLISH);
//        Decrypter decrypter = DecrypterSimpleFactory.getInstance(dataAlbanian,output, dataAlbanian , 5 ,Language.ENGLISH);
        decrypter.performDecryption();

        Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}