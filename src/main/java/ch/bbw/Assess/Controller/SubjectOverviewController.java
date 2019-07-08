package ch.bbw.Assess.Controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

import ch.bbw.Assess.Models.Note;
import ch.bbw.Assess.Models.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.round;

public class SubjectOverviewController {
	public Label lbTitle;
	public ListView lv;
	public Label lbAverage;
	private DashboardController parentController;
	private Subject subject;

	@FXML
	public ScrollPane scrollPane;

	@FXML
	public GridPane gridPane;

	private int counter = 0;
	private static final DecimalFormat df = new DecimalFormat("####0.00");

	public Subject getSubject() {
		return subject;
	}

	public void refresh() {
		ObservableList<Double> grades = FXCollections.observableArrayList();
		double average = 0;
		for (Double grade : subject.getGrades()) {
			grades.add(grade);
			average += grade;
		}

		average = average / subject.getGrades().size();
		lbAverage.setText("Ø " + df.format(average));
		if (subject.getGrades().isEmpty()) {
			lbAverage.setText("Ø 0.00");
		}

		lv.setItems(grades);

		for (Note note : subject.getNotes()) {

			Button button = new Button();
			button.setText(note.getTitle());

			if ((counter % 2) == 0) {
				gridPane.add(button, 0, gridPane.getChildren().size());
			} else {
				gridPane.add(button, 1, gridPane.getChildren().size() - 1);
			}
			counter++;
		}
	}

	public void initialize(DashboardController parentController, Subject subject) {
		this.parentController = parentController;
		this.subject = subject;

		lbTitle.setText(subject.getName());
		lbTitle.setLayoutX(360);
		refresh();
	}

	public void loadNote(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/fxml/Note.fxml"));
			Parent addSubject = fxmlLoader.load();
			NoteController noteController = fxmlLoader.getController();
			Scene newSubjectScene = new Scene(addSubject, 670, 450);
			Stage addSubjectStage = new Stage();
			addSubjectStage.setTitle("Add Note");
			addSubjectStage.getIcons().add(
					new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Views/img/icon.png"))));
			addSubjectStage.setResizable(true);
			addSubjectStage.setScene(newSubjectScene);
			noteController.initialize(this, parentController, new Note(), subject.getNotes(), false);
			addSubjectStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void addNote(final Note note) {

		final SubjectOverviewController controller = this;

		this.subject.getNotes().add(note);
		Button button = new Button();
		button.setText(note.getTitle());

		// open subject overview
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/fxml/Note.fxml"));
					Parent addSubject = fxmlLoader.load();
					NoteController noteController = fxmlLoader.getController();
					noteController.initialize(controller, parentController, note, subject.getNotes(), true);
					Scene subjectOverviewScene = new Scene(addSubject, 670, 450);
					Stage subjectOverviewStage = new Stage();
					subjectOverviewStage.setTitle(subject.getName());
					subjectOverviewStage.getIcons().add(new Image(
							Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Views/img/icon.png"))));
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

	public void addGrade() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/fxml/AddGrade.fxml"));
			Parent addGrade = fxmlLoader.load();
			AddGradeController addGradeController = fxmlLoader.getController();
			Scene newGradeScene = new Scene(addGrade, 450, 450);
			Stage addGradeStage = new Stage();
			addGradeStage.setTitle("Add Grade");
			addGradeStage.getIcons().add(
					new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Views/img/icon.png"))));
			addGradeStage.setResizable(false);
			addGradeStage.setScene(newGradeScene);
			addGradeController.initialize(this);
			addGradeStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSubject(ActionEvent event) {
		parentController.deleteSubject(subject);
		((Node) (event.getSource())).getScene().getWindow().hide();

	}
}
