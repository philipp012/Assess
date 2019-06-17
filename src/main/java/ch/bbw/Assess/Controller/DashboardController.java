package ch.bbw.Assess.Controller;

import ch.bbw.Assess.Models.Subject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    public ScrollPane scrollPane;
    public GridPane gridPane;
    private int counter = 0;
    List<Subject> subjects = new ArrayList<>();

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        gridPane.setPadding(new Insets(25));
        gridPane.setHgap(25);
        gridPane.setVgap(25);
    }

    // Add subject
    public void loadSubjectDialogue() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/fxml/AddSubject.fxml"));
            Parent addSubject = fxmlLoader.load();
            AddSubjectController addSubjectController = fxmlLoader.getController();
            Scene newSubjectScene = new Scene(addSubject, 450, 450);
            Stage addSubjectStage = new Stage();
            addSubjectStage.setTitle("Add Subject");
            addSubjectStage.getIcons().add(new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Views/img/icon.png"))));
            addSubjectStage.setResizable(false);
            addSubjectStage.setScene(newSubjectScene);
            addSubjectController.initialize(this);
            addSubjectStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addSubject(final Subject subject) {
        subjects.add(subject);
        Button button = new Button();
        button.setText(subject.getName());
        //open subject overview
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/fxml/SubjectOverview.fxml"));
                    Parent addSubject = fxmlLoader.load();
                    SubjectOverviewController subjectOverviewController = fxmlLoader.getController();
                    subjectOverviewController.initialize(DashboardController.this, subject);
                    Scene subjectOverviewScene = new Scene(addSubject, 800, 600);
                    Stage subjectOverviewStage = new Stage();
                    subjectOverviewStage.setTitle(subject.getName());
                    subjectOverviewStage.getIcons().add(new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Views/img/icon.png"))));
                    subjectOverviewStage.setResizable(true);
                    subjectOverviewStage.setScene(subjectOverviewScene);
                    subjectOverviewStage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if ((counter % 2) == 0) {
            gridPane.add(button, 0, gridPane.getChildren().size());
        } else {
            gridPane.add(button, 1, gridPane.getChildren().size() - 1);
        }
        counter++;

    }
}
