package ch.bbw.Assess.Controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddGradeController {

    public TextField tfGrade;
    private SubjectOverviewController parentController;

    void initialize(SubjectOverviewController parentController) {
        this.parentController = parentController;
    }

    public void confirmAddSubject(ActionEvent event) {
        try {
            Double grade = Double.valueOf(tfGrade.getText().trim());
            if (grade >= 1 && grade <= 6) {
                parentController.getSubject().addGrade(grade);
                parentController.refresh();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Mark");
                alert.setContentText("Please enter a value between 1 and 6");

                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Mark");
            alert.setContentText("Please enter a valid grade");

            alert.showAndWait();
        }
    }

    public void discard(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
