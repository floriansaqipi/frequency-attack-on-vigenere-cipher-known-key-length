package com.example.decrypter;

import com.example.decrypter.decryption.Decrypter;
import com.example.decrypter.util.DecrypterSimpleFactory;
import com.example.decrypter.util.Language;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        File input =  new File("src/main/java/com/example/decrypter/files/input.txt");
        File output = new File("src/main/java/com/example/decrypter/files/output.txt");

        Decrypter decrypter = DecrypterSimpleFactory.getInstance(input,output, Language.ENGLISH);

        javafx.application.Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}