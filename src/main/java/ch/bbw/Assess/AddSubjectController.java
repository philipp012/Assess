package ch.bbw.Assess;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddSubjectController {

    public TextField tfSubjectName;
    private List<Subject> subjectList = new ArrayList<>();

    void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public void confirmAddSubject(ActionEvent event) {
        if (!tfSubjectName.getText().isEmpty()) {
            Subject subject = new Subject();
            subject.setName(tfSubjectName.getText());
            subjectList.add(subject);
            System.out.println(subject.getName());
            // return subjects to Dashboard
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
    }

    public void discard(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
