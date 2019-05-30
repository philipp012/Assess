package ch.bbw.Assess;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

public class FXMLController implements Initializable {

    public ScrollPane scrollPane;
    public GridPane gridPane;
    private int counter = 0;

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
        Button button = new Button();

        if ((counter % 2) == 0) {
            gridPane.add(button, 0, gridPane.getChildren().size());
        } else {
            gridPane.add(button, 1, gridPane.getChildren().size()-1);
        }
        counter++;
    }
}
