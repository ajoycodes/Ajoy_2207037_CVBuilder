package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WelcomeController {

    @FXML
    private void startApp(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/demo/cv_builder.fxml")
            );

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((Node) e.getSource())
                    .getScene()
                    .getWindow();

            stage.setScene(scene);
            stage.setTitle("CV Builder");
            stage.show();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}