package ch.bbw.Assess;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AddSubjectController {

    public TextField tfSubjectName;
    private GridPane gridPane;

    private int counter = 0;

    void setGridpane(GridPane gridPane) {
        this.gridPane = gridPane;
    }


    public void confirmAddSubject(ActionEvent event) {

        Button button = new Button();

        if ((counter % 2) == 0) {
            gridPane.add(button, 0, gridPane.getChildren().size());
        } else {
            gridPane.add(button, 1, gridPane.getChildren().size()-1);
        }
        counter++;
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    public void discard(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
