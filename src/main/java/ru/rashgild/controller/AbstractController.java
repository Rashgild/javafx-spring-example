package ru.rashgild.controller;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import ru.rashgild.util.SpringLoader;

public abstract class AbstractController implements Controller {

    private Node view;
    private Stage stage;

    public Node getView() {
        return view;
    }

    public void setView(Node view) {
        this.view = view;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Run new scene.
     *
     * @param formName  fxml name
     */
    public Controller runController(String formName) {
        Controller controller = SpringLoader.loadControllerFxml("/fxml/" + formName + ".fxml");
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) controller.getView());
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.getIcons().add(new Image(String.valueOf(ClassLoader.getSystemResource("icon/icon.png"))));
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.show();
        controller.setStage(stage);
        return controller;
    }
}
