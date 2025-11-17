package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage st) throws Exception {
        FXMLLoader l = new FXMLLoader(getClass().getResource("cv_builder.fxml"));
        Scene sc = new Scene(l.load());
        st.setTitle("CV Builder");
        st.setScene(sc);
        st.show();
    }
}