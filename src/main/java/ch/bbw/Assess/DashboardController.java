package ch.bbw.Assess;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AddSubject.fxml"));
            Parent addSubject = fxmlLoader.load();
            AddSubjectController addSubjectController = fxmlLoader.getController();
            addSubjectController.setGridpane(gridPane);
            Scene scene1 = new Scene(addSubject, 450, 450);
            Stage addSubjectStage = new Stage();
            addSubjectStage.setTitle("Assess - Add Subject");
            addSubjectStage.getIcons().add(new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("img/icon.png"))));
            addSubjectStage.setResizable(false);
            addSubjectStage.setScene(scene1);
            addSubjectStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
