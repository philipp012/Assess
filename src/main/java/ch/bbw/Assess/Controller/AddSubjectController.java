package ch.bbw.Assess.Controller;

import ch.bbw.Assess.Models.Module;
import ch.bbw.Assess.Models.Subject;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddSubjectController {

	public TextField tfSubjectName;
	private DashboardController parentController;

	void initialize(DashboardController parentController) {
		this.parentController = parentController;
	}

	public void confirmAddSubject(ActionEvent event) {
		if (!parentController.getSubjects().isEmpty()) {
			for (Subject subject : parentController.getSubjects()) {
				if (!subject.getName().equals(tfSubjectName.getText().trim())) {
					if (!tfSubjectName.getText().trim().isEmpty()) {
						if (subject.getName().matches(".*\\d.*")) {
							Module newModule = new Module();
							newModule.setName(tfSubjectName.getText().trim());
							newModule
									.setNumber(Integer.parseInt(tfSubjectName.getText().trim().replaceAll("\\D+", "")));
							parentController.addSubject(newModule);
						} else {
							Subject newSubject = new Subject();
							newSubject.setName(tfSubjectName.getText().trim());
							parentController.addSubject(newSubject);
						}

						((Node) (event.getSource())).getScene().getWindow().hide();
					}
				} else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Duplicate Subject name");
					alert.setContentText("There is already a subject called '" + subject.getName() + "'");

					alert.showAndWait();
				}
			}
		} else {
			if (!tfSubjectName.getText().trim().isEmpty()) {
				if (tfSubjectName.getText().trim().matches(".*\\d.*")) {
					Module newModule = new Module();
					newModule.setName(tfSubjectName.getText().trim());
					newModule.setNumber(Integer.parseInt(tfSubjectName.getText().trim().replaceAll("\\D+", "")));
					parentController.addSubject(newModule);
				} else {
					Subject newSubject = new Subject();
					newSubject.setName(tfSubjectName.getText().trim());
					parentController.addSubject(newSubject);
				}
				((Node) (event.getSource())).getScene().getWindow().hide();
			}
		}
	}

	public void discard(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

}
