package ch.bbw.Assess;

import javafx.scene.control.Label;

public class SubjectOverviewController {
    public Label lbTitle;
    private DashboardController parentController;


    public void initialize(DashboardController parentController) {
        this.parentController = parentController;
    }
}
