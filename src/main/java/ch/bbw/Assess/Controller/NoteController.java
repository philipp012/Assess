package ch.bbw.Assess.Controller;

import java.util.ArrayList;
import java.util.List;

import ch.bbw.Assess.Models.Note;
import ch.bbw.Assess.Models.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.web.HTMLEditor;

public class NoteController {

	@FXML
	private HTMLEditor htmlEditor;

	@FXML
	private TextField subjectText;

	@FXML
	private TextField titleText;
	
	private DashboardController parentController;
	
	private Note note;
	
	private SubjectOverviewController subjectOverviewController;
	
	private boolean edit;
	
	List<Note> notes;

	void initialize(SubjectOverviewController subjectOverviewController, DashboardController parentController, Note note, List<Note> notes, boolean edit) {
		this.parentController = parentController;
		this.note = note;
		this.subjectOverviewController = subjectOverviewController;
		this.notes = notes;
		this.edit = edit;
		
		
		if(edit) {
			htmlEditor.setHtmlText(note.getText());
			titleText.setText(note.getTitle());
			subjectText.setText(note.getSubject());
			
			notes.remove(note);
		}
	}

	public void saveNote(ActionEvent event) {
				
		if (!subjectText.getText().trim().isEmpty()
				&& !titleText.getText().trim().isEmpty()) {
			
			note = new Note(notes.size() + 1, subjectText.getText(), titleText.getText(), htmlEditor.getHtmlText());
			
			for (Subject subject : parentController.getSubjects()) {
				if (subject.getName().toLowerCase().equals(this.subjectText.getText().toLowerCase())) {
					subject.addNote(note);
				}
			}
					
			
			notes.add(note);
			subjectOverviewController.addNote(note);

			((Node) (event.getSource())).getScene().getWindow().hide();
		}
	}

	public void cancel(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}
}