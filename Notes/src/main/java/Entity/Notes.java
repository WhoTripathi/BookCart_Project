package Entity;

import java.util.Date;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Notes {
	@Id
	private int noteId;
	@Column(length = 100)
	private String noteTitle;
	@Column(length = 500)
	private String noteInstruction;
	private Date noteDate;
	private String userEmail;
	

	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Notes(String noteTitle, String noteInstruction, Date noteDate,  String userEmail) {
		super();
		this.noteId= new Random().nextInt(1000000);
		this.noteTitle = noteTitle;
		this.noteInstruction = noteInstruction;
		this.noteDate = noteDate;
		this.userEmail = userEmail;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteInstruction() {
		return noteInstruction;
	}
	public void setNoteInstruction(String noteInstruction) {
		this.noteInstruction = noteInstruction;
	}
	public Date getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	

}
