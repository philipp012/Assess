package ch.bbw.Assess;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

public class NoteController {

	@FXML
	public HTMLEditor htmlEditor;

	@FXML
	private TextField subjectText;

	@FXML
	private TextField titleText;

	private DashboardController parentController;
	
	List<Note> notes = new ArrayList<>();

	void initialize(DashboardController parentController) {
		this.parentController = parentController;
	}

	public void saveNote(ActionEvent event) {
		if (!htmlEditor.getHtmlText().trim().isEmpty() && !subjectText.getText().trim().isEmpty()
				&& !titleText.getText().trim().isEmpty()) {
			
			Note note = new Note(notes.size() + 1, subjectText.getText(), titleText.getText(), htmlEditor.getHtmlText());

			//TODO: Subject Namen dürfen nicht mehrmals vorkommen
			for (Subject subject : parentController.getSubjects()) {
				if (subject.getName().toLowerCase().equals(this.subjectText.getText().toLowerCase())) {
					subject.addNote(note);
				}
			}
			notes.add(note);

			((Node) (event.getSource())).getScene().getWindow().hide();
		}
	}

	public void cancel(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}
}
