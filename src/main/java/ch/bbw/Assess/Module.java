package ch.bbw.Assess;

import java.util.List;

public class Module extends Subject {

	private int number;
	private List<String> competences;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<String> getCompetences() {
		return competences;
	}

	public void addCompetence(String competence) {
		this.competences.add(competence);
	}

	public void removeCompetence(String competence) {
		this.competences.remove(competence);
	}

}
