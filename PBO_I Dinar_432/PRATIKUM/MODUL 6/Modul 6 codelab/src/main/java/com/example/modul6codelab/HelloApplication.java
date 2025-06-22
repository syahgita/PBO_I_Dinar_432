package com.example.modul6codelab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    private void setTargetNumber(){
        targetNumber = 55;
    }


    private int targetNumber;
    private int attemptCount;


    private final TextField guessField = new TextField();
    private final Button guessButton = new Button("Coba Tebak!");
    private final Label feedbackLabel = new Label("Masukkan angka dari 1 - 100.");
    private final Label attemptLabel = new Label("Jumlah percobaan: 0");


    public HelloApplication() {

    }

    @Override
    public void start(Stage stage) {
        startNewGame();

        guessButton.setOnAction(_-> handleGuess());

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");
        root.getChildren().addAll(feedbackLabel, guessField, guessButton, attemptLabel);

        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Tebak Angka");
        stage.setScene(scene);
        stage.show();
    }

    private void handleGuess() {
        String userInput = guessField.getText();
        try {
            int guess = Integer.parseInt(userInput);
            attemptCount++;
            attemptLabel.setText("Jumlah percobaan: " + attemptCount);

            if (guess < targetNumber) {
                feedbackLabel.setText("Terlalu kecil!");
            } else if (guess > targetNumber) {
                feedbackLabel.setText("Terlalu besar!");
            } else {
                feedbackLabel.setText("Selamat! Angka benar.");
                guessButton.setText("Main Lagi?");
                guessButton.setOnAction(_ -> startNewGame());
            }
        } catch (NumberFormatException e) {
            feedbackLabel.setText("Input tidak valid! Masukkan angka.");
        }
    }

    private void startNewGame() {
        targetNumber = 55;
        attemptCount = 0;
        guessField.clear();
        feedbackLabel.setText("Masukkan angka dari 1 - 100.");
        attemptLabel.setText("Jumlah percobaan: 0");
        guessButton.setText("Coba Tebak!");
        guessButton.setOnAction(_-> handleGuess());
    }

    public static void main(String[] args) {
        launch();
    }
}
