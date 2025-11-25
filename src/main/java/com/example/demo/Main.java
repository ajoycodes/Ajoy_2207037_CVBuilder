package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage st) throws Exception {
        FXMLLoader l = new FXMLLoader(
                getClass().getResource("/com/example/demo/welcome.fxml")
        );
        Scene sc = new Scene(l.load());
        st.setTitle("Welcome");
        st.setScene(sc);
        st.setMaximized(true);
        st.show();
    }
}