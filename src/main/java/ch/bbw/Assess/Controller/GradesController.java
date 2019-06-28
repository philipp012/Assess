package ch.bbw.Assess.Controller;

import ch.bbw.Assess.Models.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class GradesController {
    public TableView tableView;
    private DashboardController parentcontroller;
    private List<Subject> subjectList;

    void initialize(DashboardController dashboardController, List<Subject> subjects) {
        this.parentcontroller = dashboardController;
        this.subjectList = subjects;
        for (Subject subject : subjectList) {
            ObservableList<Double> grades = FXCollections.observableArrayList();
            if (subject.getGrades() != null) {
                grades.addAll(subject.getGrades());
            }


            TableColumn<Object, Object> tableColumn = new TableColumn<>(subject.getName());
            tableColumn.setCellValueFactory(new PropertyValueFactory<>("grades"));

            //add dummy grade
            List<Double> dummyGrades = new ArrayList<>();

            dummyGrades.add(4.5);
            dummyGrades.add(6.0);
            subject.setGrades(dummyGrades);

            tableView.getItems().add(subject);
            tableView.getColumns().add(tableColumn);

        }
    }
}
