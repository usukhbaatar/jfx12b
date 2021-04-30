package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Date;

public class Main extends Application {

    // Stage -> Browser
    // Pane  -> Html Tag
    // Scene -> Body Tag

    // Components -> Elements

    Stage window;
    Pane pane;
    Scene scene;

    Button clickMe;
    int cnt = 0;
    Label info;
    Button reset;
    Date startDate;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("Click Me!");

        pane = new FlowPane();
        scene = new Scene(pane, 400, 300);

        info = new Label("0");
        info.setStyle("-fx-font-size: 18px; -fx-padding: 5px;");
        pane.getChildren().add(info);

        clickMe = new Button("Click Me!");
        clickMe.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (cnt == 0) {
                    startDate = new Date();
                    cnt++;
                    info.setText("" + cnt);
                } else {
                    Date nowDate = new Date();
                    if (nowDate.getTime() - startDate.getTime() <= 5000) {
                        cnt++;
                        info.setText("" + cnt);
                    } else {
                        info.setStyle("-fx-font-size: 18px; -fx-padding: 5px; -fx-background-color: red;");
                    }
                }
            }
        });
        pane.getChildren().add(clickMe);

        reset = new Button("Reset!");
        reset.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cnt = 0;
                info.setText("" + cnt);
                info.setStyle("-fx-font-size: 18px; -fx-padding: 5px; -fx-background-color: white;");
            }
        });
        pane.getChildren().add(reset);

        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
