package ch.bbw.Assess;

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
        if (!tfSubjectName.getText().trim().isEmpty()) {
            Subject subject = new Subject();
            System.out.println(tfSubjectName.getText().trim());
            subject.setName(tfSubjectName.getText().trim());
            parentController.addSubject(subject);
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
    }

    public void discard(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
