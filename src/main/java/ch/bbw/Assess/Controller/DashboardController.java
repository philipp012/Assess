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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

	private static File file = new File("./subjects.ser");
	public ScrollPane scrollPane;
	public GridPane gridPane;
	private int counter = 0;
	private static List<Subject> subjects = new ArrayList<>();
	private List<Subject> toAdd = new ArrayList<>();

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		readData();
		if (!subjects.isEmpty()) {
			for (Subject subject : subjects) {
				toAdd.add(subject);
			}
			for (Subject subject : toAdd) {
				addSubject(subject);
			}
		}

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
			addSubjectStage.getIcons().add(
					new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Views/img/icon.png"))));
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

		// open subject overview
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
					subjectOverviewStage.getIcons().add(new Image(
							Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Views/img/icon.png"))));
					subjectOverviewStage.setResizable(false);
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
		saveData();
	}

	public void showGrades() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/fxml/Grades.fxml"));
			Parent grades = fxmlLoader.load();
			GradesController gradesController = fxmlLoader.getController();
			Scene gradesScene = new Scene(grades, 800, 600);
			Stage gradesStage = new Stage();
			gradesStage.setTitle("Grades");
			gradesStage.getIcons().add(
					new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Views/img/icon.png"))));
			gradesStage.setResizable(false);
			gradesStage.setScene(gradesScene);
			gradesController.initialize(this, subjects);
			gradesStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readData() {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			if (fileInputStream.available() != 0) {
				ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
				subjects = (List<Subject>) inputStream.readObject();
				inputStream.close();
				fileInputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveData() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
			outputStream.writeObject(subjects);
			outputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSubject(Subject subject) {
		counter = 0;
		System.out.println("removing: " + subject.getName());
		subjects.remove(subject);
		refreshSubjects();
	}

	private void refreshSubjects() {

		saveData();
		subjects.clear();
		readData();
		gridPane.getChildren().clear();
		for (final Subject subject : subjects) {
			Button button = new Button();
			button.setText(subject.getName());
			// open subject overview
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					try {
						FXMLLoader fxmlLoader = new FXMLLoader(
								getClass().getResource("/Views/fxml/SubjectOverview.fxml"));
						Parent addSubject = fxmlLoader.load();
						SubjectOverviewController subjectOverviewController = fxmlLoader.getController();
						subjectOverviewController.initialize(DashboardController.this, subject);
						Scene subjectOverviewScene = new Scene(addSubject, 800, 600);
						Stage subjectOverviewStage = new Stage();
						subjectOverviewStage.setTitle(subject.getName());
						subjectOverviewStage.getIcons().add(new Image(
								Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Views/img/icon.png"))));
						subjectOverviewStage.setResizable(false);
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

}
