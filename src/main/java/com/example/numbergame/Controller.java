package com.example.numbergame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller implements Initializable {

    @FXML
    private Button Checkbtn;

    @FXML
    private TextField textField;
    @FXML
    private Label Label1;
    @FXML
    private Button TryAgain;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int maxAttempts = 3;
        AtomicInteger remainingAttempts = new AtomicInteger(maxAttempts);
        Label1.setText("You have " + maxAttempts + " Tries");

        Checkbtn.setOnMouseClicked(event -> {
            if (remainingAttempts.get() > 0) {
                int Guessed = Integer.parseInt(textField.getText());
                NumberGame game = new NumberGame(Guessed);
                String value = game.CheckTheGuess();

                if (Objects.equals(value, "Guessed it Right")) {
                    Label1.setText(value);
                } else {
                    remainingAttempts.decrementAndGet();
                    Label1.setText(value + " Remaining tries " + remainingAttempts.get());
                }

                if (remainingAttempts.get() == 0) {
                    Label1.setText("You are out of tries");
                    // You can disable the Checkbtn or take other actions here

                    Checkbtn.setText("Try Again");

                }
            }
        });

        TryAgain.setOnMouseClicked(event->{
            Stage oldStage = (Stage) TryAgain.getScene().getWindow();
            oldStage.close();
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GuessGame.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 750, 600);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            scene.getStylesheets().add(String.valueOf(Objects.requireNonNull(getClass().getResource("Style.css"))));
            stage.setTitle("Guess the Number Game!");
            stage.setScene(scene);
            stage.show();
        });

    }
}

