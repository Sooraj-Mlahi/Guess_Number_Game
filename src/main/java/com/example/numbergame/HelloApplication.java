package com.example.numbergame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GuessGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 600);
        scene.getStylesheets().add(String.valueOf(Objects.requireNonNull(getClass().getResource("Style.css"))));
        stage.setTitle("Guess the Number Game!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}