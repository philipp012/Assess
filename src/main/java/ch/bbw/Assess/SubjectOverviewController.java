package ch.bbw.Assess;

import javafx.scene.control.Label;

public class SubjectOverviewController {
    public Label lbTitle;
    private DashboardController parentController;
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void initialize(DashboardController parentController, Subject subject) {
        this.parentController = parentController;
        this.subject = subject;

        lbTitle.setText(subject.getName());
        lbTitle.setLayoutX(360);
    }

}
