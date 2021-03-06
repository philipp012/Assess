package ch.bbw.Assess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/fxml/Dashboard.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/Views/styles/Styles.css");
        
        stage.setTitle("Assess");
        stage.setScene(scene);
        stage.setWidth(750);
        stage.setHeight(750);
        stage.setResizable(false);
        stage.getIcons().add(new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Views/img/icon.png"))));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
