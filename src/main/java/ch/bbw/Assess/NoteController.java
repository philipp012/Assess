package ch.bbw.Assess;

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

	void initialize(DashboardController parentController) {

	}

	public void confirmAddSubject(ActionEvent event) {
		if (!htmlEditor.getHtmlText().trim().isEmpty()) {
			Note note = new Note(0, subjectText.getText(), titleText.getText(), htmlEditor.getHtmlText());
			
			((Node) (event.getSource())).getScene().getWindow().hide();
		}
	}

	public void discard(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}
}
