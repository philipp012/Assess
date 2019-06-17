package ch.bbw.Assess;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

	private int id;
	private String subject;
	private String title;
	private String text;
	private Date date;

	public Note(int id, String subject, String title, String text) {
		
		this.id = id;
		this.subject = subject;
		this.title = title;
		this.text = text;
		this.date = new Date(System.currentTimeMillis());

	}
	
	public int getId() {
		return id;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(this.date);
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
