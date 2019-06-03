package ch.bbw.Assess;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddSubjectController {

    public TextField tfSubjectName;
    private int counter = 0;


    public void confirmAddSubject() {
        /*
        Button button = new Button();

        if ((counter % 2) == 0) {
            gridPane.add(button, 0, gridPane.getChildren().size());
        } else {
            gridPane.add(button, 1, gridPane.getChildren().size()-1);
        }
        counter++;
         */
    }

    public void discard(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
