package ch.bbw.Assess.Models;

import java.util.List;

public class Subject {
    private String name;
    private List<Note> notes;
    private List<Double> grades;

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Note> getNotes() {
		return notes;
	}

	public void addNote(Note note) {
		this.notes.add(note);
	}

	public void removeNote(Note note) {
		this.notes.remove(note);
	}
}