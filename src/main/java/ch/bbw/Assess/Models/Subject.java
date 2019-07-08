package ch.bbw.Assess.Models;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private List<Note> notes = new ArrayList<>();

    private List<Double> grades = new ArrayList<>();

    public List<Double> getGrades() {
        return grades;
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

    public void addGrade(Double grade) {
        grades.add(grade);
    }

    @Override
    public String toString() {
        return this.name + " grades: " + this.grades;
    }
}