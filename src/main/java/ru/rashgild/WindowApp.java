package ru.rashgild;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.rashgild.controller.MainController;
import ru.rashgild.util.SpringLoader;

public class WindowApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(WindowApp.class);

    /**
     * Main.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        Platform.setImplicitExit(false);

        primaryStage.setTitle("Hello!");
        MainController controller = (MainController) SpringLoader.loadControllerFxml("/fxml/main.fxml");
        Scene scene = new Scene((Parent) controller.getView());
        primaryStage.setScene(scene);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        primaryStage.show();
    }
}
