package ch.bbw.Assess.Controller;

import ch.bbw.Assess.Models.Subject;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;

public class AddSubjectController {

    public TextField tfSubjectName;
    private DashboardController parentController;

    void initialize(DashboardController parentController) {
        this.parentController = parentController;
    }

    public void confirmAddSubject(ActionEvent event) {
        for (Subject subject : parentController.getSubjects())
        if (!tfSubjectName.getText().trim().isEmpty()) {
            Subject subject = new Subject();
            subject.setName(tfSubjectName.getText().trim());
            parentController.addSubject(subject);
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
    }

    public void discard(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
