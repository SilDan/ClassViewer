package org.sildan;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {
        Button button = new Button("Click me!");
        button.setOnAction(e -> System.out.println("User clicked the button!"));

        StackPane root = new StackPane(button);
        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("Hello JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
