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

        File inputAlbanian =  new File("src/main/java/com/example/decrypter/files/input_shqip.txt");
        File dataAlbanian = new File("src/main/java/com/example/decrypter/files/data_shqip.txt");

        File output = new File("src/main/java/com/example/decrypter/files/output.txt");

//        Decrypter decrypter = DecrypterSimpleFactory.getInstance(inputEnglish,output, dataEnglish, 9 ,Language.ENGLISH);
        Decrypter decrypter = DecrypterSimpleFactory.getInstance(inputAlbanian,output, dataAlbanian, 6 ,Language.ALBANIAN);
        decrypter.performDecryption();

        Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}