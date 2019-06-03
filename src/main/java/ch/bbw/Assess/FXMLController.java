package ch.bbw.Assess;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    public ScrollPane scrollPane;
    public GridPane gridPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        gridPane.setPadding(new Insets(25));
        gridPane.setHgap(25);
        gridPane.setVgap(25);

    }

    // Add subject
    public void addSubject() {
        try {
            Parent addSubject = FXMLLoader.load(getClass().getResource("/fxml/AddSubject.fxml"));
            Stage addSubjectStage = new Stage();
            addSubjectStage.setTitle("Assess - Add Subject");
            addSubjectStage.setScene(new Scene(addSubject, 450, 450));
            addSubjectStage.getIcons().add(new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("img/icon.png"))));
            addSubjectStage.setResizable(false);
            addSubjectStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
