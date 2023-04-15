package com.example.decrypter;

import com.example.decrypter.decryption.Decrypter;
import com.example.decrypter.util.DecrypterSimpleFactory;
import com.example.decrypter.util.Language;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        File input =  new File("src/main/java/com/example/decrypter/files/input.txt");
        File output = new File("src/main/java/com/example/decrypter/files/output.txt");
        File data = new File("src/main/java/com/example/decrypter/files/data.txt");

        Decrypter decrypter = DecrypterSimpleFactory.getInstance(input,output, data , 5 ,Language.ENGLISH);
        decrypter.performDecryption();

        Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}